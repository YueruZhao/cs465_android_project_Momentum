package edu.illinois.cs465.momentum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;

public class NewHabit extends AppCompatActivity implements View.OnClickListener {
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_habit);

        submitButton = (Button) findViewById(R.id.createButton);
        submitButton.setOnClickListener(this);

        String[] frequencyOptions1 = new String[] {"Times", "Days", "Weeks"};
        Spinner one = (Spinner) findViewById(R.id.FrequencySpinner1);
        ArrayAdapter<String> adapterOne = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frequencyOptions1);
        adapterOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        one.setAdapter(adapterOne);

        String[] frequencyOptions2 = new String[] {"Day", "Week", "Month", "Year"};
        Spinner two = (Spinner) findViewById(R.id.FrequencySpinner2);
        ArrayAdapter<String> adapterTwo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frequencyOptions2);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        two.setAdapter(adapterTwo);

        Switch ReminderSwitch = (Switch) findViewById(R.id.ReminderSwitch);
        ReminderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LinearLayout ReminderLayout1 = findViewById(R.id.ReminderLayout1);
                LinearLayout ReminderLayout2 = findViewById(R.id.ReminderLayout2);
                if (isChecked) {
                    ReminderLayout1.setVisibility(View.VISIBLE);
                    ReminderLayout2.setVisibility(View.VISIBLE);
                } else {
                    ReminderLayout1.setVisibility(View.GONE);
                    ReminderLayout2.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onClick(View v) {
        if (v.getId() == R.id.createButton) {
            //Intent intent = new Intent(this, _________.class);
            //startActivity(intent);
        }
    }
}
