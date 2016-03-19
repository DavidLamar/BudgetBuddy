package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
/**
 * Adds purchase amount to each category.
 * Updates budget limit when user adds one.
 *
 * Created by Chris on 2/20/2016.
 */
public class Goals extends AppCompatActivity {
    private ProgressBar gas;
    private ProgressBar entertainment;
    private ProgressBar food;
    private ProgressBar bills;
    private ProgressBar shopping;
    private ProgressBar other;

    private TextView gasProgress;
    private TextView entertainmentProgress;
    private TextView foodProgress;
    private TextView billsProgress;
    private TextView shoppingProgress;
    private TextView otherProgress;

    private int gasBudget;
    private int entertainmentBudget;
    private int foodBudget;
    private int billsBudget;
    private int shoppingBudget;
    private int otherBudget;

    private int gasProgressStatus;
    private int entertainmentProgressStatus;
    private int foodProgressStatus;
    private int billsProgressStatus;
    private int shoppingProgressStatus;
    private int otherProgressStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Creates Progressbars
        gas = (ProgressBar) findViewById(R.id.gasProgressBar);
        entertainment = (ProgressBar) findViewById(R.id.entertainmentProgressBar);
        food = (ProgressBar) findViewById(R.id.foodProgressBar);
        bills = (ProgressBar) findViewById(R.id.billsProgressBar);
        shopping = (ProgressBar) findViewById(R.id.shoppingProgressBar);
        other = (ProgressBar) findViewById(R.id.otherProgressBar);

        FileIO file = new FileIO(this);
        //Reads amount spent in each category from file
        if (file.getPurchases().length > 0) {
            Purchase[] tempPurchaseAmount = file.getPurchases();
            for (int i = 0; i < tempPurchaseAmount.length; i++) {
                if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Gas")) {
                    gasProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());
                    gas.setProgress(gasProgressStatus);
                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Entertainment")) {
                    entertainmentProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());
                    entertainment.setProgress(entertainmentProgressStatus);
                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Food")) {
                    foodProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());
                    food.setProgress(foodProgressStatus);
                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Bills")) {
                    billsProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());
                    bills.setProgress(billsProgressStatus);
                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Shopping")) {
                    shoppingProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());
                    shopping.setProgress(shoppingProgressStatus);
                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Other")) {
                    otherProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());
                    other.setProgress(otherProgressStatus);
                }
            }
        }
        //reads budget set for each category from file
        Goal[] tempCategoryBudget = file.getGoals();
        if(tempCategoryBudget != null) {
            for (int i = 0; i < tempCategoryBudget.length; i++) {
                if (tempCategoryBudget[i].getCategory().equalsIgnoreCase("Gas")) {
                    gasBudget = (int) tempCategoryBudget[i].getSpendingAmount();
                } else if (tempCategoryBudget[i].getCategory().equalsIgnoreCase("Entertainment")) {
                    entertainmentBudget = (int) tempCategoryBudget[i].getSpendingAmount();
                } else if (tempCategoryBudget[i].getCategory().equalsIgnoreCase("Food")) {
                    foodBudget = (int) tempCategoryBudget[i].getSpendingAmount();
                } else if (tempCategoryBudget[i].getCategory().equalsIgnoreCase("Bills")) {
                    billsBudget = (int) tempCategoryBudget[i].getSpendingAmount();
                } else if (tempCategoryBudget[i].getCategory().equalsIgnoreCase("Shopping")) {
                    shoppingBudget = (int) tempCategoryBudget[i].getSpendingAmount();
                } else if (tempCategoryBudget[i].getCategory().equalsIgnoreCase("Other")) {
                    otherBudget = (int) tempCategoryBudget[i].getSpendingAmount();
                }
            }
        }

        gas.setMax(gasBudget);
        entertainment.setMax(entertainmentBudget);
        food.setMax(foodBudget);
        bills.setMax(billsBudget);
        shopping.setMax(shoppingBudget);
        other.setMax(otherBudget);


        //Creates Textviews
        gasProgress = (TextView) findViewById(R.id.gasProgressDisplay);
        gasProgress.setText("You have spent $" + gasProgressStatus +
                " of your $" + gasBudget + " budget.");
        entertainmentProgress = (TextView) findViewById(R.id.entertainmentProgressDisplay);
        entertainmentProgress.setText("You have spent $" + entertainmentProgressStatus +
                " of your $" + entertainmentBudget + " budget.");
        foodProgress = (TextView) findViewById(R.id.foodProgressDisplay);
        foodProgress.setText("You have spent $" + foodProgressStatus +
                " of your $" + foodBudget + " budget.");
        billsProgress = (TextView) findViewById(R.id.billsProgressDisplay);
        billsProgress.setText("You have spent $" + billsProgressStatus +
                " of your $" + billsBudget + " budget.");
        shoppingProgress = (TextView) findViewById(R.id.shoppingProgressDisplay);
        shoppingProgress.setText("You have spent $" + shoppingProgressStatus +
                " of your $" + shoppingBudget + " budget.");
        otherProgress = (TextView) findViewById(R.id.otherProgressDisplay);
        otherProgress.setText("You have spent $" + otherProgressStatus +
                " of your $" + otherBudget + " budget.");
    }

    public void selectNewGoal(View v){
        Button button = (Button)v;
        startActivity(new Intent(getApplicationContext(), SetGoal.class));
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


}
