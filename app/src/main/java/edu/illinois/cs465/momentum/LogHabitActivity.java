package edu.illinois.cs465.momentum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogHabitActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE = "edu.illinois.cs465.NOTE";
    private EditText message_text;
    private Button did_it;
    private Button cameraButton;
    public static final int GET_FROM_GALLERY = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_habit);


        cameraButton = (Button) findViewById(R.id.btnCapture);
        message_text = (EditText) findViewById(R.id.edittext);
        did_it = (Button) findViewById(R.id.btnDidit);
        did_it.setOnClickListener(this);
        cameraButton.setOnClickListener(this);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.btnCapture) {


            startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
        }
        if (v.getId() == R.id.btnDidit) {
            String message = message_text.getText().toString();

            Intent intent= new Intent(this, HabitStatistic.class);

            intent.putExtra(EXTRA_MESSAGE,message);

            startActivity(intent);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }}
