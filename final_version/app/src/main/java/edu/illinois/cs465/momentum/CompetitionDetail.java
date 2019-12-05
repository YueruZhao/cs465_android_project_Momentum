package edu.illinois.cs465.momentum;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ProgressBar;

import android.view.ViewGroup;
import android.widget.EditText;
import android.app.*;
import android.widget.Toolbar;


import com.google.android.material.badge.BadgeUtils;

import java.util.ArrayList;

public class CompetitionDetail extends AppCompatActivity implements View.OnClickListener {
    ArrayAdapter<String> adapter2;
    ListView userList;
    ArrayList<String> userlist;
    private String m_Text = "";



//    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition_detail);
        TextView toolbarTitle1=findViewById(R.id.titleText);
        Toolbar toolbar1=findViewById(R.id.main_toolbar);
        toolbar1.setTitle("");
        toolbarTitle1.setText("Competition Detail");
        toolbar1.setBackgroundColor(getColor(R.color.competition_title_color));


//        actionBar=getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable((Color.parseColor("#ffffbb33"))));
        userList=(ListView)findViewById(R.id.participantslist);
        userlist=new ArrayList<String>();
        userlist.add("Sam                                Ranking Scores:800");
        userlist.add("Yueru                              Ranking Scores:780");
        userlist.add("Peter                              Ranking Scores:770");
        userlist.add("Sally                              Ranking Scores:700");
        userlist.add("Panda Bear                         Ranking Scores:6");

        adapter2=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,userlist);
        userList.setAdapter(adapter2);

        Button joinbtn=(Button)findViewById(R.id.joinbtn);
        joinbtn.setOnClickListener(this);

        Button friendbtn=(Button)findViewById(R.id.friendbtn);
        friendbtn.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.friendbtn) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = this.getLayoutInflater();
            View view = inflater.inflate(R.layout.edittext, null);

            builder.setView(view)
                    .setTitle("Send invitation to your friend!")
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(getApplicationContext(), "Invitation Submitted!", Toast.LENGTH_LONG).show();

                        }
                    });

//            editTextUsername = view.findViewById(R.id.edit_username);
//            editTextPassword = view.findViewById(R.id.edit_password);

            AlertDialog alertDialog=builder.create();
            alertDialog.show();


        }

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
//                            Intent i = new Intent(getBaseContext(), ItemSelection.class);


//                            textView.setVisibility(View.VISIBLE);
//                            btn.setVisibility(View.VISIBLE);
//                            pb.setVisibility(View.VISIBLE);

                            Intent intent = new Intent(getBaseContext(), CompetitionMain.class);
                            intent.putExtra("key", "joined");
                            startActivity(intent);
                        }
                    });

            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
    }
}