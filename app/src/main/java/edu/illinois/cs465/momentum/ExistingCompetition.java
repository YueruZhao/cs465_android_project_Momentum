package edu.illinois.cs465.momentum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExistingCompetition extends AppCompatActivity {

    ArrayAdapter<String> adapter2;
    ListView userList;
    ArrayList<String> userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_competition);

        userList=(ListView)findViewById(R.id.participantslist);
        userlist=new ArrayList<String>();
        userlist.add("Sam                                Ranking Scores:1200");
        userlist.add("Yueru                                Ranking Scores:980");
        userlist.add("Peter                                Ranking Scores:870");
        userlist.add("Sally                                Ranking Scores:600");
        userlist.add("Panda Bear                                Ranking Scores:6");

        adapter2=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,userlist);
        userList.setAdapter(adapter2);

    }
}
