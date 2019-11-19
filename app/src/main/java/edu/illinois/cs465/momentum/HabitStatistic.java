package edu.illinois.cs465.momentum;

import androidx.annotation.ColorLong;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.content.*;

import java.util.Calendar;

import java.util.Date;
import java.util.*;

import android.os.Parcel;
import android.util.Log;
import android.view.View;
import android.widget.*;
import java.time.LocalDate;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import android.content.Intent;



public class HabitStatistic extends AppCompatActivity implements View.OnClickListener {
    Calendar calendar = Calendar.getInstance();
    Calendar d1 = Calendar.getInstance();
    TextView thedate;
    List<Calendar> disable = new ArrayList<>();
    String note;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        d1.set(Calendar.YEAR, 2019);
        d1.set(Calendar.MONTH, 11);
        d1.set(Calendar.DAY_OF_MONTH, 17);
        disable.add(d1);


        final CalendarDay days = CalendarDay.from( 2019 , 11 , 17 );
        final CalendarDay days2 = CalendarDay.from( 2019 , 11 , 18 );
        final CalendarDay days3 = CalendarDay.from( 2019 , 11 , 1 );
        final CalendarDay days4 = CalendarDay.from( 2019 , 11 , 3 );
        final CalendarDay days5 = CalendarDay.from( 2019 , 11 , 5 );
        final CalendarDay days6 = CalendarDay.from( 2019 , 11 , 6 );
        //date for today
        final CalendarDay today = CalendarDay.from( 2019 , 11 , 21 );


        setContentView(R.layout.activity_habit_statistic);
        thedate=(TextView) findViewById(R.id.noteid);
        MaterialCalendarView materialCalendarView=(MaterialCalendarView) findViewById(R.id.calendarView);
        materialCalendarView.setDateSelected(days,true);
        materialCalendarView.setDateSelected(days2,true);
        materialCalendarView.setDateSelected(days3,true);
        materialCalendarView.setDateSelected(days4,true);
        materialCalendarView.setDateSelected(days5,true);
        materialCalendarView.setDateSelected(days6,true);



        Button btn=(Button)findViewById(R.id.viewpicid);
        btn.setOnClickListener(this);

        Intent intent = getIntent();
        note = intent.getStringExtra(LogHabitActivity.EXTRA_MESSAGE);
        if (note != null) {
            materialCalendarView.setDateSelected(today,true);
        }

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override

            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                String time=""+date;

                if (time.equals("CalendarDay{2019-11-17}")){
                    thedate.setText("I read 5 pages of Bad Blood Today!");
                    widget.setDateSelected(days,true);
                }
                if (time.equals("CalendarDay{2019-11-18}")){
                    thedate.setText("I read 3 pages of Bad Blood Today");
                    widget.setDateSelected(days2,true);
                }
                if (time.equals("CalendarDay{2019-11-1}")){
                    thedate.setText("I just read 1 page of Bad Blood Today");
                    widget.setDateSelected(days3,true);
                }
                if (time.equals("CalendarDay{2019-11-3}")){
                    thedate.setText("Almost finish half of the book");
                    widget.setDateSelected(days4,true);
                }
                if (time.equals("CalendarDay{2019-11-5}")){
                    thedate.setText("Finish 1 chapter");
                    widget.setDateSelected(days5,true);
                }
                if (time.equals("CalendarDay{2019-11-6}")){
                    thedate.setText(" 3 more chapters left");
                    widget.setDateSelected(days6,true);
                }

                //get note from intent and set today
                if (time.equals("CalendarDay{2019-11-21}")){
                    thedate.setText(note);
                    widget.setDateSelected(today,true);
                }

            }
        });

    }
    public void onClick(View v){
        if (v.getId()==R.id.viewpicid){
            Intent myIntent = new Intent(HabitStatistic.this, ViewPicture.class);
            HabitStatistic.this.startActivity(myIntent);
        }
    }
}