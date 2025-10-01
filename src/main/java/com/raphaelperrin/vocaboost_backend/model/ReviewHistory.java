package com.raphaelperrin.vocaboost_backend.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
@Table(name = "review_history")
public class ReviewHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vocabulary_item_id", nullable = false)
    private VocabularyItem vocabularyItem;

    @CreatedDate
    private Instant reviewedAt;

    @Column
    private Boolean correct;
}
