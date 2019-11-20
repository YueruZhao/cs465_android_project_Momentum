package edu.illinois.cs465.momentum;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeUtils;

import java.util.ArrayList;

public class CompetitionDetail extends AppCompatActivity implements View.OnClickListener{
    ArrayAdapter<String> adapter2;
    ListView userList;
    ArrayList<String> userlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_detail);

        userList=(ListView)findViewById(R.id.participantslist);
        userlist=new ArrayList<String>();
        userlist.add("Sam                                Ranking Scores:800");
        userlist.add("Yueru                                Ranking Scores:780");
        userlist.add("Peter                                Ranking Scores:770");
        userlist.add("Sally                                Ranking Scores:700");
        userlist.add("Panda Bear                                Ranking Scores:6");

        adapter2=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,userlist);
        userList.setAdapter(adapter2);

        Button joinbtn=(Button)findViewById(R.id.joinbtn);
        joinbtn.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.joinbtn) {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Join now?")
                    .setCancelable(false)
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Button joinbtn=(Button)findViewById(R.id.joinbtn);
                            joinbtn.setText("Joined!");

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
    }
}