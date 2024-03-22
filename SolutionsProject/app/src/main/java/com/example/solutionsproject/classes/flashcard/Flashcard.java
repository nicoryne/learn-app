package com.example.solutionsproject.classes.flashcard;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.UUID;

public class Flashcard implements Serializable {
    private final String id;
    private final String question;
    private final String answer;
    private final String[] choices;

    public Flashcard(String question, String answer) {
        this(question, answer, null);
    }

    public Flashcard(String question, String answer, String[] choices) {
        this.question = question;
        this.answer = answer;
        this.choices = choices;
        id = UUID.randomUUID().toString();
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String[] getChoices() {
        return choices;
    }

    public boolean isCorrect(String answer) {
        return this.answer.equals(answer);
    }

    public boolean isFillInTheBlank() {
        return choices == null;
    }

    public String getId() {
        return id;
    }

    @NonNull
    @Override
    public String toString() {
        return "Question: " + question + "\n"
            + "Answer: " + answer + "\n";
    }
}
