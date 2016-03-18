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
    //  public Goals goals = new Goals();
    //  public ProgressBar gas = (ProgressBar) (findViewById(R.id.gasProgressBar));;
//    String [] Goals_Spending_Categories;
    public int budget;
    public String category;
    public Goals goals = new Goals();
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

        //      Goals_Spending_Categories = getResources().getStringArray(R.array.Goals_Spending_Categories);

    }

    public void goalAdded(View v) {
         /* EditText type = (EditText) findViewById(R.id.typeField);

        /*
        Toast.makeText(getApplicationContext(), "Purchase amount: $" + amount.getText().toString() + "\n" + "Place purchased: "
                + place.getText().toString(), Toast.LENGTH_LONG).show();
        */

        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), Goals.class));

        //Set budget to user input
        EditText amount = (EditText) findViewById(R.id.amountField);
        setBudget(Integer.parseInt(amount.getText().toString()));

        //Set Category to category selected
        Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();
        setCategory(text);

        Intent i = new Intent(getApplicationContext(), Goals.class);
        i.putExtra("budget",getBudget());
        i.putExtra("category",getCategory());
        startActivity(i);

 //       doAfterClick();
        Toast.makeText(getApplicationContext(), "Goal added", Toast.LENGTH_LONG).show();

    }

//    public void doAfterClick() {
//        goals.updateProgressBarBudget();
//    }

//    class categorySpinnerClass implements AdapterView.OnItemSelectedListener {
//        @Override
//        public void onItemSelected(AdapterView<?> spinner, View view, int position, long id) {
//            TextView text = (TextView) view;
//  //          Goals category = new Goals();
//            if (position == 0) {
//                //Gas
//                //  category.updateGasProgress(Integer.parseInt(money.getText().toString()));
//            } else if (position == 1) {
//                //Entertainment
//                //  category.updateEntertainmentProgress(Integer.parseInt(money.getText().toString()));
//            } else if (position == 2) {
//                //Food
//                //  category.updateFoodProgress(Integer.parseInt(money.getText().toString()));
//            } else if (position == 3) {
//                //Bills
//                //   category.updateBillsProgress(Integer.parseInt(money.getText().toString()));
//            } else if (position == 4) {
//                //Shopping
//                //   category.updateShoppingProgress(Integer.parseInt(money.getText().toString()));
//            } else {
//                //Other
//                //   category.updateOtherProgress(Integer.parseInt(money.getText().toString()));
//            }
//            Toast.makeText(view.getContext(), "you selected " + text.getText(), Toast.LENGTH_SHORT).show();
      //  }

//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }


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

