package com.raphaelperrin.vocaboost_backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "vocabulary_progress")
public class VocabularyProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vocabulary_item_id", nullable = false)
    private VocabularyItem vocabularyItem;

    @Column
    private Date lastReviewedAt;

    @Column
    private Date nextReviewAt;

    @Column
    private Integer successiveCorrect;

    @Column
    private Float difficultyScore;

    @Column
    private Long averageResponseTimeMs;

}
