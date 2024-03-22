package com.example.solutionsproject.classes.flashcard;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class FlashcardList implements Serializable {
    private final String id;
    private String name;
    private String category;
    private Map<String, Flashcard> flashcards;
    private int currentIndex;

    public FlashcardList(String name) {
        this(name, "other");
    }

    public FlashcardList(String name, String category) {
        this.name = name;
        this.category = category;
        flashcards = new LinkedHashMap<>();
        id = UUID.randomUUID().toString();
        currentIndex = 1;
    }

    public void addFlashcard(Flashcard flashcard) {
        flashcards.put(flashcard.getId(), flashcard);
    }

    public Flashcard getFlashcard(String id) {
        return flashcards.get(id);
    }

    public void deleteFlashcard(String id) {
        flashcards.remove(id);
    }

    public int getTotalFlashcards() {
        return flashcards.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Map<String, Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(Map<String, Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    public String getId() {
        return id;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + " - " + category + "\n");

        for (Flashcard flashcard : flashcards.values()) {
            sb.append(flashcard.toString());
        }

        return sb.toString();
    }
}
