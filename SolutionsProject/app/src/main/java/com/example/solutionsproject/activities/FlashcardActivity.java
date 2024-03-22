package com.example.solutionsproject.activities;

import android.content.Intent;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.solutionsproject.R;
import com.example.solutionsproject.classes.flashcard.Flashcard;
import com.example.solutionsproject.classes.general.PomodoroService;
import com.example.solutionsproject.classes.flashcard.FlashcardList;
import com.example.solutionsproject.classes.flashcard.FlashcardManager;

import java.util.ArrayList;
import java.util.List;

public class FlashcardActivity extends AppCompatActivity {
    private TextView questionTextView;
    private LinearLayout choicesLayout;
    private TextView feedbackTextView;
    private FlashcardManager flashcardManager;
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
        feedbackTextView = findViewById(R.id.tvFeedback);

        flashcardManager = new FlashcardManager(this);
//        FlashcardList flashcardList = new FlashcardList("TEST");
//        flashcardList.addFlashcard(flashcardManager.generateFillInTheBlank("The quick brown fox jumps over the lazy dog"));
//        flashcardList.addFlashcard(flashcardManager.generateFillInTheBlank("The quick brown fox jumps over the lazy dog"));
//        flashcardList.addFlashcard(flashcardManager.generateFillInTheBlank("The quick brown fox jumps over the lazy dog"));
//        flashcardManager.addFlashcardList(flashcardList);
//        flashcardManager.save(flashcardList);

//        flashcardManager.deleteSavedFlashcardList("5004c735-e9ad-408a-827c-45f4eb16386f");
//        Log.d("FLASHCARD", String.valueOf(flashcardManager.getTotalFlashcardList()));
//        Log.d("FLASHCARD", flashcardManager.toString());

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
            choicesLayout.removeAllViews();
            if (flashcard.isFillInTheBlank()) {
                displayInputForm();
            } else {
                displayChoices(flashcard.getChoices());
            }
        } else {
            // End of flashcards
            Toast.makeText(this, "End of flashcards", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @SuppressLint("ResourceAsColor")
    private void displayInputForm() {
        EditText myEditText = new EditText(this);
        myEditText.setHint("Enter your answer");
        myEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        myEditText.setLayoutParams(layoutParams);
        myEditText.setHintTextColor(ContextCompat.getColor(this, R.color.text_primary));
        myEditText.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        myEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                checkAnswer(v, v.getText().toString());
                return true;
            }
            return false;
        });
        choicesLayout.addView(myEditText);
    }

    private void displayChoices(String[] choices) {
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
