package edu.illinois.cs465.momentum;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.content.DialogInterface;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;



import java.util.ArrayList;

public class ExistingCompetition extends AppCompatActivity implements View.OnClickListener{

    ArrayAdapter<String> adapter2;
    ListView userList;
    ArrayList<String> userlist;
//    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_competition);
//        actionBar=getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable((Color.parseColor("#ffffbb33"))));
        userList=(ListView)findViewById(R.id.participantslist);
        userlist=new ArrayList<String>();
        userlist.add("Sam                                Ranking Scores:1200");
        userlist.add("Yueru                              Ranking Scores:980");
        userlist.add("Peter                              Ranking Scores:870");
        userlist.add("Sally                              Ranking Scores:600");
        userlist.add("Panda Bear                         Ranking Scores:6");

        adapter2=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,userlist);
        userList.setAdapter(adapter2);
        Button friendbtn2=(Button)findViewById(R.id.friendbtn2);
        friendbtn2.setOnClickListener(this);

    }
    public void onClick(View v) {
        if (v.getId() == R.id.friendbtn2) {
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
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
