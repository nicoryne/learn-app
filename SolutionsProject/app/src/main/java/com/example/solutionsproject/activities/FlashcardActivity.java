package com.example.solutionsproject.activities;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.solutionsproject.R;
import com.example.solutionsproject.classes.flashcard.Flashcard;
import com.example.solutionsproject.classes.general.PomodoroService;

import java.util.ArrayList;
import java.util.List;

public class FlashcardActivity extends AppCompatActivity {
    private TextView questionTextView;
    private LinearLayout choicesLayout;
    private ImageView feedbackImageView;
    private List<Flashcard> flashcards;
    private int currentFlashcardIndex;
    boolean isRunning = false; //Pomodoro Service
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);

        View mainView = findViewById(R.id.layout);
        ImageButton back = findViewById(R.id.fc_btn_back);
        Button startTimer = findViewById(R.id.fc_btn_starttimer);

        back.setOnClickListener(v -> finish());
        startTimer.setOnClickListener(v -> {
            if(isRunning){
                stopService(v);
                startTimer.setText("Start Timer");
                isRunning = false;
            }else{
                startService(v);
                startTimer.setText("Stop Timer");
                isRunning = true;
            }
        });

        // Initialize views
        questionTextView = findViewById(R.id.tvQuestion);
        choicesLayout = findViewById(R.id.llContainer);
        feedbackImageView = findViewById(R.id.ivFeedback);

        // Initialize flashcards
        flashcards = new ArrayList<>();
        // Add your Flashcard objects here
        String[] choices = {"Primary consumer", "Secondary consumer", "Tertiary consumer", "Decomposer"};
        flashcards.add(new Flashcard("Butterfly", "Primary consumer", choices));
        flashcards.add(new Flashcard("Earthworms", "Decomposer", choices));
        flashcards.add(new Flashcard("Weasel", "Tertiary consumer", choices));
        flashcards.add(new Flashcard("Raven", "Secondary consumer", choices));

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
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 20, 20, 20);

        int rippleColor = ContextCompat.getColor(this, R.color.bg_secondary);
        int buttonColor = ContextCompat.getColor(this, R.color.bg_primary);

        for (String choice : choices) {
            Button button = new Button(this);
            button.setLayoutParams(layoutParams);
            button.setText(choice);
            button.setTextColor(Color.WHITE);

            button.setBackground(createRoundedRippleDrawable(rippleColor, buttonColor));
            button.setOnClickListener(view -> checkAnswer(view, choice));
            choicesLayout.addView(button);
        }
    }

    private RippleDrawable createRoundedRippleDrawable(int rippleColor, int buttonColor) {
        return new RippleDrawable(
                ColorStateList.valueOf(rippleColor),
                createRoundedButtonDrawable(buttonColor),
                createRoundedButtonDrawable(Color.WHITE)
        );
    }
    private GradientDrawable createRoundedButtonDrawable(int color) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadius(100);
        drawable.setColor(color);

        return drawable;
    }


    private void checkAnswer(View view, String selectedAnswer) {
        Flashcard flashcard = flashcards.get(currentFlashcardIndex);
        boolean isCorrect = flashcard.isCorrect(selectedAnswer);
        if (isCorrect) {
            feedbackImageView.setBackground(ContextCompat.getDrawable(this, R.drawable.vector_correct_mark));
        } else {
            feedbackImageView.setBackground(ContextCompat.getDrawable(this, R.drawable.vector_wrong_mark));
        }

        currentFlashcardIndex = (currentFlashcardIndex + 1) % flashcards.size(); // loop
        displayFlashcard();
    }

    public void startService(View v){
        System.out.println("Starting");
        Intent serviceIntent = new Intent(this, PomodoroService.class);

        startService(serviceIntent);
    }

    public void stopService(View v){
        Intent serviceIntent = new Intent(this, PomodoroService.class);
        stopService(serviceIntent);
    }
}
