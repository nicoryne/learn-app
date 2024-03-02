package com.example.solutionsproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.solutionsproject.R;

public class LoginActivity extends AppCompatActivity {
    private Button submitLogin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        submitLogin = findViewById(R.id.btnSubmitLogin);
        submitLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Login
                Intent intent = new Intent(LoginActivity.this, LoginSuccessActivity.class);
                startActivity(intent);
            }
        });
    }
}