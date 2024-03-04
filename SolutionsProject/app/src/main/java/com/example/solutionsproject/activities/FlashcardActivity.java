package com.example.solutionsproject.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.solutionsproject.R;
import com.example.solutionsproject.classes.flashcard.Flashcard;

import java.util.ArrayList;
import java.util.List;

public class FlashcardActivity extends AppCompatActivity {
    private TextView questionTextView;
    private LinearLayout choicesLayout;
    private TextView feedbackTextView;
    private List<Flashcard> flashcards;
    private int currentFlashcardIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        // Initialize views
        questionTextView = findViewById(R.id.tvQuestion);
        choicesLayout = findViewById(R.id.llContainer);
        feedbackTextView = findViewById(R.id.tvFeedback);

        // Initialize flashcards
        flashcards = new ArrayList<>();
        // Add your Flashcard objects here
        String[] choices = {"A", "B", "C", "D"};
        flashcards.add(new Flashcard("TEST1", "A", choices));
        flashcards.add(new Flashcard("TEST2", "B", choices));
        flashcards.add(new Flashcard("TEST3", "C", choices));
        flashcards.add(new Flashcard("TEST4", "D", choices));

        // Display the first flashcard
        currentFlashcardIndex = 0;
        displayFlashcard();
    }

    private void displayFlashcard() {
        if (currentFlashcardIndex < flashcards.size()) {
            Flashcard flashcard = flashcards.get(currentFlashcardIndex);
            questionTextView.setText(flashcard.getQuestion());
            displayChoices(flashcard.getChoices());
        } else {
            // End of flashcards
            Toast.makeText(this, "End of flashcards", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void displayChoices(String[] choices) {
        choicesLayout.removeAllViews();
        for (String choice : choices) {
            Button button = new Button(this);
            button.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            button.setText(choice);
            button.setOnClickListener(view -> checkAnswer(view, choice));
            choicesLayout.addView(button);
        }
    }

    private void checkAnswer(View view, String selectedAnswer) {
        Flashcard flashcard = flashcards.get(currentFlashcardIndex);
        boolean isCorrect = flashcard.isCorrect(selectedAnswer);
        if (isCorrect) {
            feedbackTextView.setText("Correct!");
            feedbackTextView.setTextColor(Color.GREEN);
        } else {
            feedbackTextView.setText("Incorrect!");
            feedbackTextView.setTextColor(Color.RED);
        }

        currentFlashcardIndex = (currentFlashcardIndex + 1) % flashcards.size(); // loop
        displayFlashcard();
    }
}
