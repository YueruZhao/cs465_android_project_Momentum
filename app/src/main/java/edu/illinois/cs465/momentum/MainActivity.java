package edu.illinois.cs465.momentum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String CURRENT_HABIT = "edu.illinois.cs465.momentum.CURRENTHABIT";
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //navigation bar
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.habit:
                    return true;
                case R.id.competition:
                    return true;
                case R.id.browse:
                    return true;
            }
            return false;
        }
    };

//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.habit:
//                        Toast.makeText(MainActivity.this, "Recents", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.competition:
//                        Toast.makeText(MainActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.browse:
//                        Toast.makeText(MainActivity.this, "Nearby", Toast.LENGTH_SHORT).show();
//                        break;                }
//                return true;
//            }
//        });

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
