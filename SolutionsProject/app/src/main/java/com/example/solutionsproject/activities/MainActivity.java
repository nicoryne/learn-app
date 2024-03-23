package com.example.solutionsproject.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.solutionsproject.R;
import com.example.solutionsproject.classes.opening.OnBoardingAdapter;
import com.example.solutionsproject.classes.opening.OnBoardingModel;

import org.ini4j.Ini;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private OnBoardingAdapter onBoardingAdapter;
    private ViewPager2 viewPagerOnboarding;
    private LinearLayout linearLayoutPageIndicator;
    private TextView skipButton;
    private ConstraintLayout authButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SessionManager session = new SessionManager(getApplicationContext());
//        if (session.isLoggedIn()) {
//            // User is logged in
//            Toast.makeText(MainActivity.this, "Welcome " + session.getCurrentUser().getName(), Toast.LENGTH_LONG).show();
//        } else {
//            // User is not logged in
//            Toast.makeText(MainActivity.this, "NOT LOGGED IN", Toast.LENGTH_LONG).show();
//        }

        viewPagerOnboarding = findViewById(R.id.view_pager_onboarding);
        linearLayoutPageIndicator = findViewById(R.id.linear_onboarding_indicator);
        skipButton = findViewById(R.id.btnSkipOpening);
        authButtons = findViewById(R.id.button);

        List<OnBoardingModel> onBoardingModels = new ArrayList<>();
        onBoardingModels.add(new OnBoardingModel(R.drawable.onboarding_img_1, "Numerous free trial courses", "Free courses for you to discover!"));
        onBoardingModels.add(new OnBoardingModel(R.drawable.onboarding_img_2, "Quick and easy learning", "Accessible services provided in various ways, to accompany all your learning styles!"));
        onBoardingModels.add(new OnBoardingModel(R.drawable.onboarding_img_3, "Create your own study plan", "Study at your own pace! Making yourself consistent and motivated."));

        onBoardingAdapter = new OnBoardingAdapter(onBoardingModels);
        viewPagerOnboarding.setAdapter(onBoardingAdapter);

        Button openSignUp = findViewById(R.id.btnSignup);
        Button openLogIn = findViewById(R.id.btnLogin);

        // Page Dot Indicators
        ImageView[] indicators = new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 10, 10, 10);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive));
            indicators[i].setLayoutParams(layoutParams);
            linearLayoutPageIndicator.addView(indicators[i]);
        }

        setCurrentOnBoardingIndicator(0);

        viewPagerOnboarding.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerOnboarding.setCurrentItem(onBoardingAdapter.getItemCount() - 1);
            }
        });

        openLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        openSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setCurrentOnBoardingIndicator(int index) {
        int childCount = linearLayoutPageIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) linearLayoutPageIndicator.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive));
            }
        }

        if (index == onBoardingAdapter.getItemCount() - 1) {
            if (skipButton.getVisibility() != View.GONE) skipButton.setVisibility(View.GONE);
            if (authButtons.getVisibility() != View.VISIBLE)
                authButtons.setVisibility(View.VISIBLE);
        } else {
            if (skipButton.getVisibility() != View.VISIBLE) skipButton.setVisibility(View.VISIBLE);
            if (authButtons.getVisibility() != View.GONE) authButtons.setVisibility(View.GONE);
        }
    }
}