package com.raphaelperrin.vocaboost_backend.controller;

import com.raphaelperrin.vocaboost_backend.model.User;
import com.raphaelperrin.vocaboost_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;

@RestController
@RequestMapping("/api/oauth2")
public class AuthController {

    private final UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/google")
    public ResponseEntity<User> googleAuthentication(@RequestBody Map<String, String> body) throws Exception {
        try {
            String idToken = body.get("id_token");
            User user = userService.processGoogleToken(idToken);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).build();
        } catch (GeneralSecurityException | IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/callback")
    public String oauth2Callback(@RequestParam(required = false) String code, @RequestParam(required = false) String state) {
        return "Token Received";
    }
}
