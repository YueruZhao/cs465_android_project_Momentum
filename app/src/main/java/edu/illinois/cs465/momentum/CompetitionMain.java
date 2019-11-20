package edu.illinois.cs465.momentum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CompetitionMain extends AppCompatActivity {
    public static final String CURRENT_COMPETITION = "edu.illinois.cs465.momentum.CURRENTHABIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_main);
    }
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
