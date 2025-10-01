package com.raphaelperrin.vocaboost_backend.service;

import com.raphaelperrin.vocaboost_backend.repository.VocabularyProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VocabularyProgressService {

    private final VocabularyProgressRepository vocabularyProgressRepository;

    @Autowired
    public VocabularyProgressService(VocabularyProgressRepository vocabularyProgressRepository) {
        this.vocabularyProgressRepository = vocabularyProgressRepository;
    }
}
