package com.raphaelperrin.vocaboost_backend.repository;

import com.raphaelperrin.vocaboost_backend.model.VocabularyItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabularyItemRepository extends JpaRepository<VocabularyItem, Long> {
}
