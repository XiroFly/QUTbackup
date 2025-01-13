package com.example.moblieapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.moblieapp.R;

public class MainActivity extends Activity {
    String msg = "Android : ";

    /** 当活动第一次被创建时调用 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button openSecondActivityButton = findViewById(R.id.openSecondActivityButton);
        openSecondActivityButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             // 创建一个Intent对象，以启动SecondActivity
             Intent intent = new Intent(MainActivity.this, Activity2.class);
             startActivity(intent);
         }
        });
        Log.d(msg, "The onCreate() event for MainActivity");
    }

    /** 当活动即将可见时调用 */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event for MainActivity");
    }

    /** 当活动可见时调用 */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event for MainActivity");
    }

    /** 当其他活动获得焦点时调用 */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event for MainActivity");
    }

    /** 当活动不再可见时调用 */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event for MainActivity");
    }

    /** 当活动将被销毁时调用 */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event for MainActivity");
    }
    public void print(View view){
        Log.i("myButton", "print: myButton");
    }
}