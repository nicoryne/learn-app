package com.example.solutionsproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

    public class account_activity extends Activity {

        @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        ImageView rectangle_53 = findViewById(R.id.rectangle_53_ek);
        ImageView rectangle_53_ek1 = findViewById(R.id.rectangle_53_eke);
        ImageView rectangle_53_ek2 = findViewById(R.id.rectangle_53_ek2);
        ImageView rectangle_53_ek3 = findViewById(R.id.rectangle_53_ek3);
        ImageView search = findViewById(R.id.search);
        ImageView home = findViewById(R.id.hone);
        ImageView course = findViewById(R.id.course);
        ImageView message = findViewById(R.id.message);

        //custom code goes here
        rectangle_53.setOnClickListener(v -> Toast.makeText(account_activity.this, "favorite placeholder", Toast.LENGTH_SHORT).show());

        rectangle_53_ek1.setOnClickListener(v -> Toast.makeText(account_activity.this, "edit account placeholder", Toast.LENGTH_SHORT).show());

        rectangle_53_ek2.setOnClickListener(v -> Toast.makeText(account_activity.this, "settings and privacy placeholder", Toast.LENGTH_SHORT).show());

        rectangle_53_ek3.setOnClickListener(v -> Toast.makeText(account_activity.this, "help placeholder", Toast.LENGTH_SHORT).show());

        search.setOnClickListener(v -> Toast.makeText(account_activity.this, "search placeholder", Toast.LENGTH_SHORT).show());

        //footer nav
        home.setOnClickListener(v -> startActivity(new Intent(account_activity.this, home_activity.class)));

        course.setOnClickListener(v -> startActivity(new Intent(account_activity.this, courses_activity.class)));

        message.setOnClickListener(v -> startActivity(new Intent(account_activity.this, message_4_activity.class)));
    }
}

	