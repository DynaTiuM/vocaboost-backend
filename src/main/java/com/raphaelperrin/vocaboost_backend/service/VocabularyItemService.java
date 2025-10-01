package com.raphaelperrin.vocaboost_backend.service;

import com.raphaelperrin.vocaboost_backend.model.VocabularyItem;
import com.raphaelperrin.vocaboost_backend.repository.VocabularyItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VocabularyItemService {
    private final VocabularyItemRepository vocabularyItemRepository;

    @Autowired
    public VocabularyItemService(VocabularyItemRepository vocabularyItemRepository) {
        this.vocabularyItemRepository = vocabularyItemRepository;
    }

    public List<VocabularyItem> getAllVocabularyItems() {
        return vocabularyItemRepository.findAll();
    }

    public Optional<VocabularyItem> getVocabularyItemById(long id) {
        return vocabularyItemRepository.findById(id);
    }

    public VocabularyItem addVocabularyItem(VocabularyItem vocabularyItem) {
        return vocabularyItemRepository.save(vocabularyItem);
    }

    public VocabularyItem updateVocabularyItem(Long id, VocabularyItem vocabularyItem) {
        VocabularyItem existingItem = vocabularyItemRepository.findById(id).
                orElseThrow(() -> new RuntimeException("VocabularyItem not found with id: "+ id));
        existingItem.setFrenchTranslation(vocabularyItem.getFrenchTranslation());
        existingItem.setGermanTranslation(vocabularyItem.getGermanTranslation());
        return vocabularyItemRepository.save(existingItem);
    }

    public void deleteVocabularyItem(Long id) {
        vocabularyItemRepository.deleteById(id);
    }
}
