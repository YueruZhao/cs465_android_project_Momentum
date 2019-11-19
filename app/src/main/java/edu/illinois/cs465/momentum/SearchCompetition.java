package edu.illinois.cs465.momentum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class SearchCompetition extends AppCompatActivity {
    SearchView mySearchView;
    ListView myList;

//        Competiton competiton1;
//        Competiton competiton2;
//        Competiton competiton3;
//        Competiton competiton4;

    ArrayList<String> list;

    String[] items;

    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mySearchView=(SearchView)findViewById(R.id.searchView);

        myList=(ListView)findViewById(R.id.myList);
        list=new ArrayList<String>();




        list.add("Meditate Once a Week");
        list.add("Write in my journal everyday");
        list.add("Go to the gym once a week");
        list.add("Read a new book every month");
        list.add("Clean my bedroom every 2 weeks");
        list.add("Drink 8 Glasses of Water everyday");
        list.add("Deposit $50 every week");
        list.add("Get 8 hours of sleep everyday");
        list.add("Pray Everyday");
        list.add("No Soda");
        list.add("Call my parents once a month");

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);


        myList.setAdapter(adapter);
        myList.setClickable(true);
        items = list.toArray(new String[list.size()]);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (items[position].equals("Drink 8 Glasses of Water everyday")){
                    Intent showdetailIntent = new Intent(SearchCompetition.this, CompetitionDetail.class);
                    SearchCompetition.this.startActivity(showdetailIntent);
                }

            }
        });

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


    }

}