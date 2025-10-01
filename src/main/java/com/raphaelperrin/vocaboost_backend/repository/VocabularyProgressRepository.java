package com.raphaelperrin.vocaboost_backend.repository;

import com.raphaelperrin.vocaboost_backend.model.VocabularyProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabularyProgressRepository extends JpaRepository<VocabularyProgress, Long> {
}
