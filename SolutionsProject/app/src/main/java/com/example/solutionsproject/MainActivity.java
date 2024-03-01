package com.example.solutionsproject;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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
    private static final String TAG = "MainActivity";
    private List<OnBoardingModel> onBoardingModels;
    private OnBoardingAapter onBoardingAapter;
    ViewPager2 viewPagerOnboarding;
    LinearLayout linearLayoutPageIndicator;
    MaterialButton materialButton;
    ConstraintLayout button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerOnboarding = findViewById(R.id.view_pager_onboarding);
        linearLayoutPageIndicator = findViewById(R.id.linear_onboarding_indicator);
        materialButton = findViewById(R.id.btn_action_onboarding);
        button = findViewById(R.id.button);

        onBoardingModels = new ArrayList<>();
        onBoardingModels.add(new OnBoardingModel(R.drawable.ic_launcher_foreground, "Numerous free trial courses", "Free courses for you to discover!"));
        onBoardingModels.add(new OnBoardingModel(R.drawable.ic_launcher_foreground, "Quick and easy learning", "Accessible services provided in various ways, to accompany all your learning styles!"));
        onBoardingModels.add(new OnBoardingModel(R.drawable.ic_launcher_foreground, "Create your own study plan", "Study at your own pace! Making yourself consistent and motivated."));

        onBoardingAapter = new OnBoardingAapter(onBoardingModels);
        viewPagerOnboarding.setAdapter(onBoardingAapter);
        Button OpenSignUp = findViewById(R.id.btnSignup);
        Button OpenLogIn = findViewById(R.id.btnLogin);

        ImageView[] indicators = new ImageView[onBoardingAapter.getItemCount()];
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

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPagerOnboarding.setCurrentItem(onBoardingAapter.getItemCount() - 1);
            }
        });

        OpenLogIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                                .inflate(R.layout.modal_bottom_sheet, (LinearLayout) findViewById(R.id.modalBottomSheetContainer));
                        bottomSheetView.findViewById(R.id.modal_switch);

                        // Authentication UI Components
                        TextView modalHeader = bottomSheetView.findViewById(R.id.modal_header);
                        TextView modalSubHeader = bottomSheetView.findViewById(R.id.modal_sub_header);
                        TextView forgotPassword = bottomSheetView.findViewById(R.id.forgot_password);
                        TextView modalSwitchDesc = bottomSheetView.findViewById(R.id.modal_switch_desc);
                        TextView modalSwitchLink = bottomSheetView.findViewById(R.id.modal_switch_link);
                        CheckBox termsConditions = bottomSheetView.findViewById(R.id.terms_conditions);
                        ConstraintLayout thirdPartyAuth = bottomSheetView.findViewById(R.id.third_party_auth);
                        Button modalSubmitButton = bottomSheetView.findViewById(R.id.modal_submit_button);

                        modalHeader.setText("LogIn");
                        modalSubHeader.setVisibility(View.INVISIBLE);
                        modalSubmitButton.setText("Log in");
                        termsConditions.setVisibility(View.GONE);
                        modalSwitchDesc.setText("Don't have an account?");
                        modalSwitchLink.setText("Sign up");
                        forgotPassword.setVisibility(View.VISIBLE);
                        thirdPartyAuth.setVisibility(View.VISIBLE);

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
                                .inflate(R.layout.modal_bottom_sheet, (LinearLayout) findViewById(R.id.modalBottomSheetContainer));
                        bottomSheetView.findViewById(R.id.modal_switch);

                        // Authentication UI Components
                        TextView modalHeader = bottomSheetView.findViewById(R.id.modal_header);
                        TextView modalSubHeader = bottomSheetView.findViewById(R.id.modal_sub_header);
                        TextView forgotPassword = bottomSheetView.findViewById(R.id.forgot_password);
                        TextView modalSwitchDesc = bottomSheetView.findViewById(R.id.modal_switch_desc);
                        TextView modalSwitchLink = bottomSheetView.findViewById(R.id.modal_switch_link);
                        CheckBox termsConditions = bottomSheetView.findViewById(R.id.terms_conditions);
                        ConstraintLayout thirdPartyAuth = bottomSheetView.findViewById(R.id.third_party_auth);
                        Button modalSubmitButton = bottomSheetView.findViewById(R.id.modal_submit_button);

                        modalHeader.setText("SignUp");
                        modalSubHeader.setVisibility(View.VISIBLE);
                        modalSubmitButton.setText("Sign up");
                        termsConditions.setVisibility(View.VISIBLE);
                        modalSwitchDesc.setText("Already have an account?");
                        modalSwitchLink.setText("Log in");
                        forgotPassword.setVisibility(View.GONE);
                        thirdPartyAuth.setVisibility(View.GONE);

                        bottomSheetDialog.setContentView(bottomSheetView);
                        bottomSheetDialog.show();
                    }
                }
        );
    }

    private void setCurrentOnBoardingIndicator(int index) {
        int childCount = linearLayoutPageIndicator.getChildCount();
        Log.d(TAG, "setCurrentOnBoardingIndicator: " + viewPagerOnboarding.getChildCount());
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) linearLayoutPageIndicator.getChildAt(i);
            Log.d(TAG, "setCurrentOnBoardingIndicator: " + i + " " + index);
            if (i == index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive));
            }
        }
        if (index == onBoardingAapter.getItemCount() - 1) {
            materialButton.setVisibility(View.GONE);
            button.setVisibility(View.VISIBLE);
        } else {
            if (materialButton.getVisibility() != View.VISIBLE) {
                materialButton.setVisibility(View.VISIBLE);
            }

            if (button.getVisibility() != View.GONE) {
                button.setVisibility(View.GONE);
            }
            materialButton.setText("Skip");
        }
    }
}