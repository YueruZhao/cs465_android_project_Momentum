package edu.illinois.cs465.momentum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LogHabitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_habit);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String habitName = intent.getStringExtra(MainActivity.CURRENT_HABIT);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(habitName);

    }
}
