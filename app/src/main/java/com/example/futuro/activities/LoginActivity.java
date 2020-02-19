package com.example.futuro.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.futuro.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void startMudaActivity(View view) {

        Intent adicionardActivity = new Intent(this, MainActivity.class);
        startActivity(adicionardActivity);
    }
}