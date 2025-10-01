package com.raphaelperrin.vocaboost_backend.model;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "vocabulary_item")
public class VocabularyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String germanTranslation;

    @Column(nullable = false)
    private String frenchTranslation;

    @Column(nullable = true)
    private String exampleSentence;

    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    public VocabularyItem() {}

    public VocabularyItem(String germanTranslation, String frenchTranslation) {
        this.germanTranslation = germanTranslation;
        this.frenchTranslation = frenchTranslation;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getGermanTranslation() {
        return this.germanTranslation;
    }

    public void setGermanTranslation(String germanTranslation) {
        this.germanTranslation = germanTranslation;
    }

    public String getFrenchTranslation() {
        return this.frenchTranslation;
    }

    public void setFrenchTranslation(String frenchTranslation) {
        this.frenchTranslation = frenchTranslation;
    }

    public String getExampleSentence() {
        return this.exampleSentence;
    }
    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public Instant getUpdatedAt() {
        return this.updatedAt;
    }
    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "VocabularyItem: {" +
                "id: " + this.id +
                "germanTranslation: " + germanTranslation +
                "frenchTranslation: " + frenchTranslation +
                "}";
    }
}
