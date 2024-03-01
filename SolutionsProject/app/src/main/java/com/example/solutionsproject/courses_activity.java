package com.example.solutionsproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

    public class courses_activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);

        ImageView message = findViewById(R.id.message);
        ImageView search = findViewById(R.id.search);
        ImageView tab_on__background_ = findViewById(R.id.tab_on__background_);
        ImageView tab_on__background__ek1 = findViewById(R.id.tab_on__background__ek1);
        ImageView tab_on__background__ek2 = findViewById(R.id.tab_on__background__ek2);
        ImageView bg = findViewById(R.id.bg);
        ImageView home = findViewById(R.id.home);
        ImageView account = findViewById(R.id.account);
        ImageView search__background_ = findViewById(R.id.search__background_);
        ImageView profile = findViewById(R.id.profile);


        //custom code goes here
        search.setOnClickListener(v -> Toast.makeText(courses_activity.this, "search placeholder", Toast.LENGTH_SHORT).show());

        search__background_.setOnClickListener(v -> Toast.makeText(courses_activity.this, "search bar placeholder", Toast.LENGTH_SHORT).show());

        tab_on__background_.setOnClickListener(v -> Toast.makeText(courses_activity.this, "all tab placeholder", Toast.LENGTH_SHORT).show());

        tab_on__background__ek1.setOnClickListener(v -> Toast.makeText(courses_activity.this, "popular tab placeholder", Toast.LENGTH_SHORT).show());

        tab_on__background__ek2.setOnClickListener(v -> Toast.makeText(courses_activity.this, "new tab placeholder", Toast.LENGTH_SHORT).show());

        bg.setOnClickListener(v -> startActivity(new Intent(courses_activity.this, course_details_activity.class)));

        profile.setOnClickListener(v -> startActivity(new Intent(courses_activity.this, account_activity.class)));

        //footer nav
        account.setOnClickListener(v -> startActivity(new Intent(courses_activity.this, account_activity.class)));

        home.setOnClickListener(v -> startActivity(new Intent(courses_activity.this, home_activity.class)));

        message.setOnClickListener(v -> startActivity(new Intent(courses_activity.this, message_4_activity.class)));
    }
}
	
	