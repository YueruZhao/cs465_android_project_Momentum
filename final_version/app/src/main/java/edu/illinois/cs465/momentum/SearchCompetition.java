package edu.illinois.cs465.momentum;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
    ArrayList<String> list;
    String[] items;
    ArrayAdapter<String> adapter;
//    private ActionBar actionBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_competition);
//        actionBar=getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable((Color.parseColor("#ffffbb33"))));



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
                if (position==0){
                    Intent showdetailIntent3 = new Intent(SearchCompetition.this, CompetitionDetail.class);
                    SearchCompetition.this.startActivity(showdetailIntent3);
                }
//                Toast toast = Toast.makeText(SearchCompetition.this, ""+items[position], Toast.LENGTH_SHORT);
//                toast.show();
                if (items[position].equals("Drink 8 Glasses of Water everyday")){
//                    Toast toast1 = Toast.makeText(SearchCompetition.this, "water", Toast.LENGTH_SHORT);
//                    toast1.show();
                    Intent showdetailIntent = new Intent(SearchCompetition.this, CompetitionDetail.class);
                    SearchCompetition.this.startActivity(showdetailIntent);
                }

            }
        });
        mySearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast toast = Toast.makeText(SearchCompetition.this, "here", Toast.LENGTH_SHORT);
//                toast.show();
                mySearchView.setIconified(false);
                mySearchView.onActionViewExpanded();
                Intent showdetailIntent2 = new Intent(SearchCompetition.this, CompetitionDetail.class);
                SearchCompetition.this.startActivity(showdetailIntent2);
            }
        });

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


    }

}