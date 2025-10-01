package com.raphaelperrin.vocaboost_backend.controller;

import com.raphaelperrin.vocaboost_backend.model.VocabularyItem;
import com.raphaelperrin.vocaboost_backend.service.VocabularyItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vocabulary")
public class VocabularyItemController {
    private final VocabularyItemService vocabularyItemService;

    @Autowired
    public VocabularyItemController(VocabularyItemService vocabularyItemService) {
        this.vocabularyItemService = vocabularyItemService;
    }

    @GetMapping
    public List<VocabularyItem> getAllVocabularyItems() {
        return this.vocabularyItemService.getAllVocabularyItems();
    }

    @GetMapping("/{id}")
    public Optional<VocabularyItem> getVocabularyItemById(@PathVariable Long id) {
        return this.vocabularyItemService.getVocabularyItemById(id);
    }

    @PostMapping
    public VocabularyItem addVocabularyItem(@RequestBody VocabularyItem vocabularyItem) {
        return this.vocabularyItemService.addVocabularyItem(vocabularyItem);
    }

    @PutMapping("/{id}")
    public VocabularyItem updateVocabularyItem(@PathVariable Long id, @RequestBody VocabularyItem vocabularyItem) {
        vocabularyItem.setId(id);
        return this.vocabularyItemService.updateVocabularyItem(id, vocabularyItem);
    }

    @DeleteMapping("/{id}")
    public void deleteVocabularyItem(@PathVariable Long id) {
        this.vocabularyItemService.deleteVocabularyItem(id);
    }
}
