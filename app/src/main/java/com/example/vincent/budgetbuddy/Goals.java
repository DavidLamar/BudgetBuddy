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

    private int gasProgressStatus;
    private int entertainmentProgressStatus;
    private int foodProgressStatus;
    private int billsProgressStatus;
    private int shoppingProgressStatus;
    private int otherProgressStatus;

    private int gasBudget;
    private int entertainmentBudget;
    private int foodBudget;
    private int billsBudget;
    private int shoppingBudget;
    private int otherBudget;

  //  private AppCompatActivity activity;

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


        // Hard code in progressbar budget (TEMP)
//        gas.setProgress(20);
//        entertainment.setProgress(99);
//        food.setProgress(99);
//        bills.setProgress(75);
//        shopping.setProgress(30);
//        other.setProgress(5);

        FileIO file = new FileIO(this);
        if(file.getPurchases().length > 0) {
            Purchase[] temp = file.getPurchases();
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].getCategory().equalsIgnoreCase("Gas")) {
                    gasProgressStatus += Integer.parseInt(temp[i].getPrice());
                    gas.setProgress(gasProgressStatus);
                } else if (temp[i].getCategory().equalsIgnoreCase("Entertainment")) {
                    entertainmentProgressStatus += Integer.parseInt(temp[i].getPrice());
                    entertainment.setProgress(entertainmentProgressStatus);
                } else if (temp[i].getCategory().equalsIgnoreCase("Food")) {
                    foodProgressStatus += Integer.parseInt(temp[i].getPrice());
                    food.setProgress(foodProgressStatus);
                } else if (temp[i].getCategory().equalsIgnoreCase("Bills")) {
                    billsProgressStatus += Integer.parseInt(temp[i].getPrice());
                    bills.setProgress(billsProgressStatus);
                } else if (temp[i].getCategory().equalsIgnoreCase("Shopping")) {
                    shoppingProgressStatus += Integer.parseInt(temp[i].getPrice());
                    shopping.setProgress(shoppingProgressStatus);
                } else if (temp[i].getCategory().equalsIgnoreCase("Other")) {
                    otherProgressStatus += Integer.parseInt(temp[i].getPrice());
                    other.setProgress(otherProgressStatus);
                }
            }
        }

        // Brings Budget and Category from user input in SetGoal.java
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int budget = extras.getInt("budget");
            String category = extras.getString("category");
            updateProgressBarBudget(category, budget);
        }

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
        Updates the category budgets to user set inputs in SetGoal.java
    */
    public void updateProgressBarBudget(String pCategory, int pBudget){
         if (pCategory.equalsIgnoreCase("Entertainment")) {
            entertainmentBudget = pBudget;
            entertainment.setMax(entertainmentBudget);
        } else if (pCategory.equalsIgnoreCase("Food")) {
            foodBudget = pBudget;
            food.setMax(foodBudget);
        } else if (pCategory.equalsIgnoreCase("Bills")) {
            billsBudget = pBudget;
            bills.setMax(billsBudget);
        } else if (pCategory.equalsIgnoreCase("Shopping")) {
            shoppingBudget = pBudget;
            shopping.setMax(shoppingBudget);
        } else if (pCategory.equalsIgnoreCase("Other")) {
            otherBudget = pBudget;
            other.setMax(otherBudget);
        } else if (pCategory.equalsIgnoreCase("Gas")) {
            gasBudget = pBudget;
            gas.setMax(gasBudget);
        }
    }




//    /*
//     * @param pPurchase Takes recent purchase for gas and adds it to total spent in category.
//     * @return returns updated spending on gas.
//    **/
//    public int updateGasProgress (int pPurchase){
//        gasProgressStatus += setGoal.getBudget();
//        gas.setProgress(gasProgressStatus);
//        return gasProgressStatus;
//    }
//
//    /**
//     * @param pPurchase Takes recent purchase for entertainment and adds it to total spent in category.
//     * @return returns updated spending on entertainment.
//     **/
//    public int updateEntertainmentProgress (int pPurchase){
//        entertainmentProgressStatus += pPurchase;
//        entertainment.setProgress(entertainmentProgressStatus);
//        return entertainmentProgressStatus;
//    }
//
//    /**
//     * @param pPurchase Takes recent purchase for bills and adds it to total spent in category.
//     * @return updated spending on bills.
//     **/
//    public int updateBillsProgress (int pPurchase){
//        billsProgressStatus += pPurchase;
//        bills.setProgress(billsProgressStatus);
//        return billsProgressStatus;
//    }
//
//    /**
//     * @param pPurchase Takes recent purchase for food and adds it to total spent in category.
//     * @return updated spending on bills.
//     **/
//    public int updateFoodProgress (int pPurchase){
//        foodProgressStatus += pPurchase;
//        food.setProgress(foodProgressStatus);
//        return foodProgressStatus;
//    }
//
//    /**
//     * @param pPurchase Takes recent purchase for shopping and adds it to total spent in category.
//     * @return returns updated spending on shopping.
//     **/
//    public int updateShoppingProgress (int pPurchase){
//        shoppingProgressStatus += pPurchase;
//        shopping.setProgress(shoppingProgressStatus);
//        return shoppingProgressStatus;
//    }
//
//    /**
//     * @param pPurchase Takes recent purchase for other and adds it to total spent in category.
//     * @return returns updated spending on other.
//     **/
//    public int updateOtherProgress (int pPurchase){
//        otherProgressStatus += pPurchase;
//        other.setProgress(otherProgressStatus);
//        return otherProgressStatus;
//    }
//
//    /**
//     * @param pAmount  Will convert money spent in a category to a percentage of 100%,
//     * where 100% is the budget that was set. (purchase / budget) x 100
//     *
//     **/
//    public void convertToPercentage(int pAmount) {
//
//    }

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
