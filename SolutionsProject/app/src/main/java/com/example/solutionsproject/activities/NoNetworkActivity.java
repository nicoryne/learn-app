package com.example.solutionsproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.solutionsproject.R;

public class NoNetworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_network);

        ImageButton btnBack = (ImageButton) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> startActivity(new Intent(NoNetworkActivity.this, HomeActivity.class)));
    }
}