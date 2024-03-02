package com.example.solutionsproject.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.solutionsproject.R;

public class SignupActivity extends AppCompatActivity {
    private Button submitSignup;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        submitSignup = findViewById(R.id.btnSubmitSignup);
        submitSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Registration
            }
        });
    }
}