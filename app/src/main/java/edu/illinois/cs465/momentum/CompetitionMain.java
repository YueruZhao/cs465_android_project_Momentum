package edu.illinois.cs465.momentum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CompetitionMain extends AppCompatActivity {
    public static final String CURRENT_COMPETITION = "edu.illinois.cs465.momentum.CURRENTHABIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_main);

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
                    Intent competitionIntent = new Intent(CompetitionMain.this, MainActivity.class);
                    CompetitionMain.this.startActivity(competitionIntent);
                    return true;
                case R.id.browse:
                    Intent searchIntent = new Intent(CompetitionMain.this, SearchCompetition.class);
                    CompetitionMain.this.startActivity(searchIntent);
                    return true;
            }
            return false;
        }
    };

    public void createCompetition(View view) {
        Intent intent = new Intent(this, NewCompetition.class);
        startActivity(intent);
    }

    public void browseCompetition(View view) {
        Intent intent = new Intent(this, SearchCompetition.class);
        startActivity(intent);
    }

    public void competitionDetail(View view) {
        Intent intent = new Intent(this, ExistingCompetition.class);
        intent.putExtra(CURRENT_COMPETITION, "medidation");
        startActivity(intent);
    }


    public void LogHabit(View view) {
        Intent intent = new Intent(this, LogHabitActivity.class);
        TextView comp;
        if ( view.getId() == R.id.logcomp1){
            comp = findViewById(R.id.comp1);
        } else{
            comp = findViewById(R.id.comp2);
        }
        String compName = comp.getText().toString();
        intent.putExtra(CURRENT_COMPETITION, compName);
        startActivity(intent);
    }



}
