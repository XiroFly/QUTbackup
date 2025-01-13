package com.example.shiyan3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView stopwatchTextView;
    private Button startButton;
    private Button stopButton;
    private Button fastForwardButton;

    private StopwatchHandler stopwatchHandler;
    private StopwatchService stopwatchService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopwatchTextView = findViewById(R.id.stopwatchTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        fastForwardButton = findViewById(R.id.fastForwardButton);

        stopwatchHandler = new StopwatchHandler();
        stopwatchService = new StopwatchService(stopwatchHandler);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopwatchService.startStopwatch();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopwatchService.stopStopwatch();
            }
        });

        fastForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopwatchService.fastForward();
            }
        });
    }

    private class StopwatchHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int seconds = msg.arg1;
            updateStopwatch(seconds);
        }
    }

    private void updateStopwatch(int seconds) {
        stopwatchTextView.setText(String.valueOf(seconds));
    }
}
