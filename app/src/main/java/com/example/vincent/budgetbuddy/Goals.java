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

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Goals extends AppCompatActivity {
    private ProgressBar gas;
    private ProgressBar entertainment;
    private ProgressBar food;
    private ProgressBar bills;
    private ProgressBar shopping;
    private ProgressBar other;

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

        gas = (ProgressBar) findViewById(R.id.gasProgressBar);
        entertainment = (ProgressBar) findViewById(R.id.entertainmentProgressBar);
        food = (ProgressBar) findViewById(R.id.foodProgressBar);
        bills = (ProgressBar) findViewById(R.id.billsProgressBar);
        shopping = (ProgressBar) findViewById(R.id.shoppingProgressBar);
        other = (ProgressBar) findViewById(R.id.otherProgressBar);


        // call method to Add recent purchase amount here to each progress bar

        gas.setProgress(gasProgressStatus);
        entertainment.setProgress(entertainmentProgressStatus);
        food.setProgress(foodProgressStatus);
        bills.setProgress(billsProgressStatus);
        shopping.setProgress(shoppingProgressStatus);
        other.setProgress(otherProgressStatus);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    
    /*
     * @param pPurchase Takes recent purchase for gas and adds it to total spent in category.
     * @return returns updated spending on gas.
    **/
    public int updateGasProgress (int pPurchase){

        return gasProgressStatus;
    }

    /**
     * @param pPurchase Takes recent purchase for entertainment and adds it to total spent in category.
     * @return returns updated spending on entertainment.
     **/
    public int updateEntertainmentProgress (int pPurchase){

        return entertainmentProgressStatus;
    }

    /**
     * @param pPurchase Takes recent purchase for bills and adds it to total spent in category.
     * @return updated spending on bills.
     **/
    public int updateBillsProgress (int pPurchase){

        return billsProgressStatus;
    }

    /**
     * @param pPurchase Takes recent purchase for shopping and adds it to total spent in category.
     * @return returns updated spending on shopping.
     **/
    public int updateShoppingProgress (int pPurchase){

        return shoppingProgressStatus;
    }

    /**
     * @param pPurchase Takes recent purchase for other and adds it to total spent in category.
     * @return returns updated spending on other.
     **/
    public int updateOtherProgress (int pPurchase){

        return otherProgressStatus;
    }

    /**
     * @param pAmount  Will convert money spent in a category to a percentage of 100%,
     * where 100% is the budget that was set. (purchase / budget) x 100
     *
     **/
    public void convertToPercentage(int pAmount) {

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
