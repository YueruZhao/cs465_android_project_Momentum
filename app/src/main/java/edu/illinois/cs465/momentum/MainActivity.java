package edu.illinois.cs465.momentum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String CURRENT_HABIT = "edu.illinois.cs465.momentum.CURRENTHABIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createHabit(View view) {
        Intent intent = new Intent(this, NewHabit.class);
        startActivity(intent);
    }

    public void habitDetail(View view) {
        Intent intent = new Intent(this, HabitStatistic.class);
        startActivity(intent);
    }

    //add function to get habit name based on log in button number
    public void LogHabit(View view) {
        Intent intent = new Intent(this, LogHabitActivity.class);
        TextView habit;
        if ( view.getId() == R.id.loghabit1){
            habit = findViewById(R.id.habit1);
        } else{
            habit = findViewById(R.id.habit2);
        }
        String habitName = habit.getText().toString();
        intent.putExtra(CURRENT_HABIT, habitName);
        startActivity(intent);
    }

}
