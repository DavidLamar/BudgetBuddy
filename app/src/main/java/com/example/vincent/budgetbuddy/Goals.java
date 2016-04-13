package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
        Purchase[] tempPurchaseAmount = file.getPurchases();
        if (tempPurchaseAmount != null) {
            for (int i = 0; i < tempPurchaseAmount.length; i++) {
                if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Gas")) {
                    gasProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());

                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Entertainment")) {
                    entertainmentProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());

                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Food")) {
                    foodProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());

                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Bills")) {
                    billsProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());

                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Shopping")) {
                    shoppingProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());

                } else if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Other")) {
                    otherProgressStatus += Integer.parseInt(tempPurchaseAmount[i].getPrice());

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
        gas.setProgress(gasProgressStatus);
        entertainment.setProgress(entertainmentProgressStatus);
        food.setProgress(foodProgressStatus);
        bills.setProgress(billsProgressStatus);
        shopping.setProgress(shoppingProgressStatus);
        other.setProgress(otherProgressStatus);

        //Other ProgressBar
        if((double)otherProgressStatus/(double)otherBudget < 0.5) {
            other.getProgressDrawable().setColorFilter(
                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
        }
         else if((double)otherProgressStatus/(double)otherBudget >= 0.5 &&
                (double)otherProgressStatus/(double)otherBudget < 0.75) {
            other.getProgressDrawable().setColorFilter(
                    Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else
            other.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

        //Gas ProgressBar
        if((double)gasProgressStatus/(double)gasBudget < 0.5) {
            gas.getProgressDrawable().setColorFilter(
                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if((double)gasProgressStatus/(double)gasBudget >= 0.5 &&
                (double)gasProgressStatus/(double)gasBudget < 0.75) {
            gas.getProgressDrawable().setColorFilter(
                    Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else
            gas.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

        //Entertainment ProgressBar
        Log.i("color", Integer.toString(entertainmentProgressStatus/entertainmentBudget));
        if((double)entertainmentProgressStatus/(double)entertainmentBudget < 0.5) {
            entertainment.getProgressDrawable().setColorFilter(
                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if((double)entertainmentProgressStatus/(double)entertainmentBudget >= 0.5 &&
                (double)entertainmentProgressStatus/(double)entertainmentBudget < 0.75) {
            entertainment.getProgressDrawable().setColorFilter(
                    Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else
            entertainment.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

        //Bills ProgressBar
        if((double)billsProgressStatus/(double)billsBudget < 0.5) {
            bills.getProgressDrawable().setColorFilter(
                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if((double)billsProgressStatus/(double)billsBudget >= 0.5 &&
                (double)billsProgressStatus/(double)billsBudget < 0.75) {
            bills.getProgressDrawable().setColorFilter(
                    Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else
            bills.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

        //Food ProgressBar
        if((double)foodProgressStatus/(double)foodBudget < 0.5) {
            food.getProgressDrawable().setColorFilter(
                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if((double)foodProgressStatus/(double)foodBudget >= 0.5 &&
                (double)foodProgressStatus/(double)foodBudget < 0.75) {
            food.getProgressDrawable().setColorFilter(
                    Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else
            food.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

        //Shopping ProgressBar
        if((double)shoppingProgressStatus/(double)shoppingBudget < 0.5) {
            shopping.getProgressDrawable().setColorFilter(
                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else if((double)shoppingProgressStatus/(double)shoppingBudget >= 0.5 &&
                (double)shoppingProgressStatus/(double)shoppingBudget < 0.75) {
            shopping.getProgressDrawable().setColorFilter(
                    Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        else
            shopping.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

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
