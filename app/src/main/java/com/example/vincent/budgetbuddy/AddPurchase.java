package com.example.vincent.budgetbuddy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddPurchase extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    private Spinner spinner;
    private static final String[] paths = {"Cash", "Check", "Credit", "Debit"};

    Calendar calendar= Calendar.getInstance();
    DatePickerDialog dialog;
    private int year = calendar.get(calendar.YEAR);
    private int month = calendar.get(calendar.MONTH);
    private int day = calendar.get(calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinner = (Spinner) findViewById(R.id.purchaseType);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddPurchase.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        ((Button) findViewById(R.id.setDateButton)).setText(month + "/" + day + "/" + year);

    }

    public void setDate(View view){
        dialog = new DatePickerDialog(this, this, year, month, day);
        dialog.show();
    }

    public void displayInfo(View view) {

        String money = ((EditText) findViewById(R.id.moneyField)).getText().toString();
        String place = ((EditText) findViewById(R.id.placeField)).getText().toString().replace(" ", "_");
        String date = month + "/" + day + "/" + year;
        Spinner category = (Spinner) findViewById(R.id.categorySpinner);
        Spinner methodOfPurchase = (Spinner) findViewById(R.id.purchaseType);

        String textOfCategory = category.getSelectedItem().toString();
        String textOfMethodPurchase = methodOfPurchase.getSelectedItem().toString();

        if(money.equals("") || place.equals("")){
            Toast.makeText(getApplicationContext(), "Cannot have blank cost or location", Toast.LENGTH_SHORT).show();
            return;
        }


        Purchase newPurchase = new Purchase(money, date, place, textOfMethodPurchase, textOfCategory);
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
        FileIO fio = new FileIO(this);
        fio.addPurchase(p);
    }

    public void deletePurchases(){

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        this.month = monthOfYear;
        this.day = dayOfMonth;
        ((Button) findViewById(R.id.setDateButton)).setText(month + "/" + day + "/" + year);
    }
}