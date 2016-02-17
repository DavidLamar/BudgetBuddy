package com.example.vincent.budgetbuddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AddPurchase extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String OUTPUT_FILE = "purchase_data.txt";

    private Spinner spinner;
    private static final String[] paths = {"Cash", "Check", "Credit", "Debit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddPurchase.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //REMOVE THIS LATER!!!@ *****************************************************************************************************
        //deletePurchases();

    }

    public void displayInfo(View view) {

        EditText money = (EditText) findViewById(R.id.moneyField);
        EditText place = (EditText) findViewById(R.id.placeField);
        EditText date = (EditText) findViewById(R.id.endDateField);

        Purchase newPurchase = new Purchase(money.getText().toString(), date.getText().toString(), place.getText().toString(), spinner.getSelectedItem().toString(), "Category");
        savePurchase(newPurchase);
        /*
        Toast.makeText(getApplicationContext(), "Purchase amount: $" + amount.getText().toString() + "\n" + "Place purchased: "
                + place.getText().toString(), Toast.LENGTH_LONG).show();
        */
        Toast.makeText(getApplicationContext(), "Purchase added", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), BudgetBuddy.class));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void selectPurchase(View v){
        Button button = (Button)v;
        startActivity(new Intent(getApplicationContext(), AddPurchase.class));
    }

    public void selectGoals(View v){
        Button button = (Button)v;
        startActivity(new Intent(getApplicationContext(), Goals.class));
    }

    public void selectSpending(View v){
        Button button = (Button)v;
        startActivity(new Intent(getApplicationContext(), Spending.class));
    }

    public void selectHome(View v){
        Button button = (Button)v;
        startActivity(new Intent(getApplicationContext(), BudgetBuddy.class));
    }

    public void savePurchase(Purchase p){
        try {
            File file = new File(getFilesDir(), OUTPUT_FILE);
            String saveText = p.getPrice() + " " + p.getMethod() + " " + p.getDate() + " " + p.getLocation() + " " + p.getCategory() + "-";
            ArrayList<String> lines = new ArrayList<String>();
            FileOutputStream fos;
            FileInputStream fis;

            try {
                //We need to load in the text file first, so that it doesn't all get deleted
                fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                lines = new ArrayList<String>();
                String[] s = br.readLine().split("-");
                Log.i("File ", "____________________Loading text file...__________________________");
                for(int i = 0; i < s.length; i++){
                    lines.add(s[i] + "-");
                    Log.i("File ", "Loading: " + s[i]);
                }
                fis.close();
            } catch (Exception e) {
                Log.i("File", "No file");
            }

            lines.add(saveText);

            try {
                //Then write all of our stuff back to the file. This will get a lot slower
                //as more files are added. But that will only be after thousands of entries.
                fos = new FileOutputStream(file);
                for(int i = 0; i < lines.size(); i++){
                    fos.write(lines.get(i).getBytes());
                }
                Log.i("File", "Saving: " + saveText);
                fos.close();

            } catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deletePurchases(){
        File file = new File(getFilesDir(), OUTPUT_FILE);
        file.delete();
    }
}
