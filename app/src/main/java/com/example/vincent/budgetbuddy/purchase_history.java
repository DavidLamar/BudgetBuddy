package com.example.vincent.budgetbuddy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.vincent.budgetbuddy.R;

import java.util.ArrayList;

public class purchase_history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView lv = (ListView) findViewById(R.id.purchaseList);
        ArrayList<String> list = new ArrayList<String>();
        FileIO fio = new FileIO(this);
        Purchase[] p = fio.getPurchases();
        for(int i = 0; i < p.length; i++){
            list.add(p[i].getDate() + " - $" + p[i].getPrice() + " at " + p[i].getLocation() );
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);


    }

}
