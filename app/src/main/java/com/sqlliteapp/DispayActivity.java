package com.sqlliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DispayActivity extends AppCompatActivity {

    ListView listView;
    String products[] = {"Product 1","Product 2","Product 3","Product 4","Product 5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispay);
        listView = findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter <String>(this, android.R.layout.simple_list_item_1,products);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String strData = adapterView.getItemAtPosition(i).toString();

                Intent I = new Intent(DispayActivity.this,UpdateActivity.class);
                I.putExtra("KEY_DATA",strData);
                startActivity(I);
            }
        });
    }
}