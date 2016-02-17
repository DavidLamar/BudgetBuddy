package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SetGoal extends AppCompatActivity {
  //  public Goals goals = new Goals();
//    public ProgressBar gas = (ProgressBar) (findViewById(R.id.gasProgressBar));;

//    public int budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }

    public void goalAdded(View v){
         /* EditText type = (EditText) findViewById(R.id.typeField);

        /*
        Toast.makeText(getApplicationContext(), "Purchase amount: $" + amount.getText().toString() + "\n" + "Place purchased: "
                + place.getText().toString(), Toast.LENGTH_LONG).show();
        */

        Button button = (Button)v;
        startActivity(new Intent(getApplicationContext(), Goals.class));

 //       EditText amount = (EditText) findViewById(R.id.amountField);
 //       int amountParse = Integer.parseInt(amount.getText().toString());

        Toast.makeText(getApplicationContext(), "Goal added", Toast.LENGTH_LONG).show();

//        setBudget(amountParse);
  //      setBudgetLimit();

    }
/*
    public void setBudget(int pBudget) {
        budget = pBudget;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudgetLimit() {
        gas.setMax(getBudget());
    }
*/
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

}
