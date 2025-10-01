package com.raphaelperrin.vocaboost_backend.repository;

import com.raphaelperrin.vocaboost_backend.model.ReviewHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewHistoryRepository extends JpaRepository<ReviewHistory, Integer> {
}
