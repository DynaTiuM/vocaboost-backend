package com.raphaelperrin.vocaboost_backend.service;

import com.raphaelperrin.vocaboost_backend.repository.ReviewHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewHistoryService {

    private final ReviewHistoryRepository reviewHistoryRepository;

    @Autowired
    public ReviewHistoryService(ReviewHistoryRepository reviewHistoryRepository) {
        this.reviewHistoryRepository = reviewHistoryRepository;
    }

}
