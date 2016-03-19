package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Allows user to select category and set a budget.
 *
 * Created by Chris on 2/20/2016.
 */

public class SetGoal extends AppCompatActivity {
    public int budget;
    public String category;
    public Goals goals = new Goals();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //      Goals_Spending_Categories = getResources().getStringArray(R.array.Goals_Spending_Categories);
    }

    public void goalAdded(View v) {
         /* EditText type = (EditText) findViewById(R.id.typeField);

        /*
        Toast.makeText(getApplicationContext(), "Purchase amount: $" + amount.getText().toString() + "\n" + "Place purchased: "
                + place.getText().toString(), Toast.LENGTH_LONG).show();
        */

  //      Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), Goals.class));

        //Set budget to user input
        EditText amount = (EditText) findViewById(R.id.amountField);
        setBudget(Integer.parseInt(amount.getText().toString()));

        //Set Category to category selected
        Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();
        setCategory(text);

        FileIO file = new FileIO(this);
        Goal g = new Goal(getCategory(), getBudget());
        file.addGoal(g);

 //       doAfterClick();
        Toast.makeText(getApplicationContext(), "Goal added", Toast.LENGTH_LONG).show();

    }

        public void setBudget(int pBudget) {
            budget = pBudget;
        }

        public int getBudget() {
            return budget;
        }

        public void setCategory(String pCategory) { category = pCategory; }

        public String getCategory(){ return category; }



        public void selectPurchase(View v) {
            Button button = (Button) v;
            startActivity(new Intent(getApplicationContext(), AddPurchase.class));
        }

        public void selectGoals(View v) {
            Button button = (Button) v;
            startActivity(new Intent(getApplicationContext(), Goals.class));
        }

        public void selectSpending(View v) {
            Button button = (Button) v;
            startActivity(new Intent(getApplicationContext(), Spending.class));
        }

        public void selectHome(View v) {
            Button button = (Button) v;
            startActivity(new Intent(getApplicationContext(), BudgetBuddy.class));
        }

    }

