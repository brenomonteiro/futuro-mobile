package com.example.futuro.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.futuro.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView) findViewById(R.id.idScan);
        ImageView img2 = (ImageView) findViewById(R.id.idListAlunos);
    }

    public void startSecondActivity(View view) {

        Intent secondActivity = new Intent(this, ScanActivity.class);
        startActivity(secondActivity);
    }
    public void startThirdActivity(View view) {

        Intent thirdActivity = new Intent(this, ListActivity.class);
        startActivity(thirdActivity);
    }

}
