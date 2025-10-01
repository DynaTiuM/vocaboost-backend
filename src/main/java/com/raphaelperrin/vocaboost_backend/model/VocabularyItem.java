package com.raphaelperrin.vocaboost_backend.model;
import jakarta.persistence.*;

@Entity
@Table(name = "vocabulary_item")
public class VocabularyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String germanTranslation;

    @Column(nullable = false)
    private String frenchTranslation;

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

    @Override
    public String toString() {
        return "VocabularyItem: {" +
                "id: " + this.id +
                "germanTranslation: " + germanTranslation +
                "frenchTranslation: " + frenchTranslation +
                "}";
    }
}
