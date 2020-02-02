package com.example.futuro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView) findViewById(R.id.idScan);

    }

    public void startSecondActivity(View view) {

        Intent secondActivity = new Intent(this, ScanActivity.class);
        startActivity(secondActivity);
    }

}
