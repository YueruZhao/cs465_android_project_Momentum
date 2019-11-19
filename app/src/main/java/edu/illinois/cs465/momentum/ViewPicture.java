package edu.illinois.cs465.momentum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;


public class ViewPicture extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_picture);
        ImageView img=(ImageView)findViewById(R.id.second_activity);
        img.setBackgroundResource(R.drawable.bookpic);
    }

}