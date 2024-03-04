package com.example.solutionsproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.solutionsproject.R;

public class NoCoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_courses);

        ImageButton btnBack = (ImageButton) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> startActivity(new Intent(NoCoursesActivity.this, HomeActivity.class)));
    }
}