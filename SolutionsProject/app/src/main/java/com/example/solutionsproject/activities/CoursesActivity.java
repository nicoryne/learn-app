package com.example.solutionsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.solutionsproject.R;

public class CoursesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        ImageView message = findViewById(R.id.message);
        ImageView search = findViewById(R.id.search);
        ImageView tab_on__background_ = findViewById(R.id.tab_on__background_);
        ImageView tab_on__background__ek1 = findViewById(R.id.tab_on__background__ek1);
        ImageView tab_on__background__ek2 = findViewById(R.id.tab_on__background__ek2);
        ConstraintLayout course_list_ek2 = findViewById(R.id.course_list_ek2);
        ImageView home = findViewById(R.id.home);
        ImageView account = findViewById(R.id.account);
        ImageView search__background_ = findViewById(R.id.search__background_);
        ImageView profile = findViewById(R.id.profile);


        //custom code goes here
        search.setOnClickListener(v -> Toast.makeText(CoursesActivity.this, "search placeholder", Toast.LENGTH_SHORT).show());

        search__background_.setOnClickListener(v -> Toast.makeText(CoursesActivity.this, "search bar placeholder", Toast.LENGTH_SHORT).show());

        tab_on__background_.setOnClickListener(v -> Toast.makeText(CoursesActivity.this, "all tab placeholder", Toast.LENGTH_SHORT).show());

        tab_on__background__ek1.setOnClickListener(v -> Toast.makeText(CoursesActivity.this, "popular tab placeholder", Toast.LENGTH_SHORT).show());

        tab_on__background__ek2.setOnClickListener(v -> Toast.makeText(CoursesActivity.this, "new tab placeholder", Toast.LENGTH_SHORT).show());

        course_list_ek2.setOnClickListener(v -> startActivity(new Intent(CoursesActivity.this, CourseDetailsActivity.class)));

        profile.setOnClickListener(v -> startActivity(new Intent(CoursesActivity.this, AccountActivity.class)));

        //footer nav
        account.setOnClickListener(v -> startActivity(new Intent(CoursesActivity.this, AccountActivity.class)));

        home.setOnClickListener(v -> startActivity(new Intent(CoursesActivity.this, HomeActivity.class)));

        message.setOnClickListener(v -> startActivity(new Intent(CoursesActivity.this, MessagesActivity.class)));
    }
}
	
	