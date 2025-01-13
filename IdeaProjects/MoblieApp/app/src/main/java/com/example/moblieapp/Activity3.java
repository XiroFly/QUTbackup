package com.example.moblieapp;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Log.d("ThirdActivity","onCreate called");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ThirdActivity", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ThirdActivity", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ThirdActivity", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ThirdActivity", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ThirdActivity", "onDestroy called");
    }

}