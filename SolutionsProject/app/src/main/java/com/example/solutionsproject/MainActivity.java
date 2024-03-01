package com.example.solutionsproject;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<OnBoardingModel> onBoardingModels;
    private OnBoardingAdapter onBoardingAdapter;
    private ViewPager2 viewPagerOnboarding;
    private LinearLayout linearLayoutPageIndicator;
    private TextView skipButton;
    private ConstraintLayout authButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerOnboarding = findViewById(R.id.view_pager_onboarding);
        linearLayoutPageIndicator = findViewById(R.id.linear_onboarding_indicator);
        skipButton = findViewById(R.id.btnSkipOpening);
        authButtons = findViewById(R.id.button);

        onBoardingModels = new ArrayList<>();
        onBoardingModels.add(new OnBoardingModel(R.drawable.ic_launcher_foreground, "Numerous free trial courses", "Free courses for you to discover!"));
        onBoardingModels.add(new OnBoardingModel(R.drawable.ic_launcher_foreground, "Quick and easy learning", "Accessible services provided in various ways, to accompany all your learning styles!"));
        onBoardingModels.add(new OnBoardingModel(R.drawable.ic_launcher_foreground, "Create your own study plan", "Study at your own pace! Making yourself consistent and motivated."));

        onBoardingAdapter = new OnBoardingAdapter(onBoardingModels);
        viewPagerOnboarding.setAdapter(onBoardingAdapter);

        Button OpenSignUp = findViewById(R.id.btnSignup);
        Button OpenLogIn = findViewById(R.id.btnLogin);

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

        OpenLogIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                                .inflate(R.layout.bottom_sheet_login, (LinearLayout) findViewById(R.id.modalBottomSheetContainer));
                        bottomSheetView.findViewById(R.id.modal_switch);

                        bottomSheetDialog.setContentView(bottomSheetView);
                        bottomSheetDialog.show();
                    }
                }
        );

        OpenSignUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                                .inflate(R.layout.bottom_sheet_signup, (LinearLayout) findViewById(R.id.modalBottomSheetContainer));
                        bottomSheetView.findViewById(R.id.modal_switch);

                        bottomSheetDialog.setContentView(bottomSheetView);
                        bottomSheetDialog.show();
                    }
                }
        );

        // Bottom Sheet Layout
        LayoutInflater inflater = getLayoutInflater();
        View bottomSheetLogin = inflater.inflate(R.layout.bottom_sheet_login, null);

        Button submitLoginButton = bottomSheetLogin.findViewById(R.id.btnSubmitLogin);
        submitLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Pop up dialog login success layout
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
            if (skipButton.getVisibility() != View.GONE)
                skipButton.setVisibility(View.GONE);
            if (authButtons.getVisibility() != View.VISIBLE)
                authButtons.setVisibility(View.VISIBLE);
        } else {
            if (skipButton.getVisibility() != View.VISIBLE)
                skipButton.setVisibility(View.VISIBLE);
            if (authButtons.getVisibility() != View.GONE)
                authButtons.setVisibility(View.GONE);
        }
    }
}