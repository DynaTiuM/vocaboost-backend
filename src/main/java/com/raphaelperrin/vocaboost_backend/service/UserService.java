package com.raphaelperrin.vocaboost_backend.service;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.raphaelperrin.vocaboost_backend.model.User;
import com.raphaelperrin.vocaboost_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.json.JsonFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    @Value("${google.client-id}")
    private String googleClientId;

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User processGoogleToken(String idTokenString) throws GeneralSecurityException, IOException {
        logger.info("Token received ({} chars): {}", idTokenString.length(), idTokenString);
        idTokenString = idTokenString.replaceAll("\\s+", "");

        NetHttpTransport transport = new NetHttpTransport();
        JsonFactory jsonFactory = new GsonFactory();

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(googleClientId))
                .build();

        GoogleIdToken idToken;
        try {
            idToken = verifier.verify(idTokenString);
        } catch (Exception e) {
            logger.error("Erreur lors de la vérification du token : {}", e.getMessage(), e);
            throw e;
        }

        if (idToken == null) {
            logger.info("null");
            throw new IllegalArgumentException("Invalid ID token.");
        }


        Payload payload = idToken.getPayload();
        String email = payload.getEmail();
        Boolean emailVerified = payload.getEmailVerified();

        logger.info("Payload: {}", payload);
        logger.debug("Email verified: {}", payload.getEmailVerified());

        if (emailVerified == null || !emailVerified) {
            throw new IllegalArgumentException("Invalid email address.");
        }

        String username = (String) payload.get("name");
        String pictureUrl = (String) payload.get("picture");

        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user;
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        else {
            user = new User(email, username);
            user.setPictureUrl(pictureUrl);
            this.userRepository.save(user);
        }

        return user;
    }
}
