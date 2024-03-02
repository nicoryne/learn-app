package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.solutionsproject.R;

public class AccountActivity extends Activity {

        @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        View cell_ek2 = findViewById(R.id.cell_ek2);
        View cell_ek4 = findViewById(R.id.cell_ek4);
        View cell_ek6 = findViewById(R.id.cell_ek6);
        View cell_ek8 = findViewById(R.id.cell_ek8);
        ImageView search = findViewById(R.id.search);
        ImageView home = findViewById(R.id.hone);
        ImageView course = findViewById(R.id.course);
        ImageView message = findViewById(R.id.message);

        //custom code goes here
        cell_ek2.setOnClickListener(v -> Toast.makeText(AccountActivity.this, "favorite placeholder", Toast.LENGTH_SHORT).show());

        cell_ek4.setOnClickListener(v -> Toast.makeText(AccountActivity.this, "edit account placeholder", Toast.LENGTH_SHORT).show());

        cell_ek6.setOnClickListener(v -> Toast.makeText(AccountActivity.this, "settings and privacy placeholder", Toast.LENGTH_SHORT).show());

        cell_ek8.setOnClickListener(v -> Toast.makeText(AccountActivity.this, "help placeholder", Toast.LENGTH_SHORT).show());

        search.setOnClickListener(v -> Toast.makeText(AccountActivity.this, "search placeholder", Toast.LENGTH_SHORT).show());

        //footer nav
        home.setOnClickListener(v -> startActivity(new Intent(AccountActivity.this, HomeActivity.class)));

        course.setOnClickListener(v -> startActivity(new Intent(AccountActivity.this, CoursesActivity.class)));

        message.setOnClickListener(v -> startActivity(new Intent(AccountActivity.this, MessagesActivity.class)));
    }
}

	