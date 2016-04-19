package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BudgetBuddy extends AppCompatActivity {

    private TextView totalBudget;
    private TextView[] rPurchases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_buddy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FileIO file = new FileIO(this);


        //Handles the recent purchases
        if(file.checkPurchases()){
            ListView lv = (ListView) findViewById(R.id.recentPurchases);
            ArrayList<String> list = new ArrayList<String>();
            Purchase[] p = file.getPurchases();
            for(int i = p.length - 1; i >= 0; i--){
                list.add(p[i].getDate() + " - $" + p[i].getPrice() + " at " + p[i].getLocation() );
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);
        } else {
            ListView lv = (ListView) findViewById(R.id.recentPurchases);
            ArrayList<String> list = new ArrayList<String>();
            list.add("No recent purchases...");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);
        }




        totalBudget = (TextView) findViewById(R.id.totalBudget);
        try {
            // combines total budget across all categories
            int budgetsCombined = 0;
            Goal[] tempCategoryBudget = file.getGoals();
            for (int i = 0; i < tempCategoryBudget.length; i++) {
                budgetsCombined += tempCategoryBudget[i].getSpendingAmount();
            }
            //sets total budget to textview

            totalBudget.setText("Your total budget is $" + budgetsCombined);
        } catch (Exception e){
            totalBudget.setText("You have no budget set yet...");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_budget_buddy, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(getApplicationContext(), Settings.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    public void selectHomeButton(View v){
        Button button = (Button)v;
        startActivity(new Intent(getApplicationContext(), BudgetBuddy.class));
    }


    public void TEST(){
        boolean testbool = true;
        FileIO fileIOTest = new FileIO(this);
        fileIOTest.deletePurchase();
        fileIOTest.deleteGoal();
        Purchase[] purchases = new Purchase[18];
        purchases[0] = new Purchase("55", "10/10/10", "Subway", "Cash", "Food");
        purchases[1] = new Purchase("12", "10/10/11", "GasStation", "Credit", "Gas");
        purchases[2] = new Purchase("2", "10/10/12", "Movies", "Cash", "Entertainment");
        purchases[3] = new Purchase("100", "10/10/13", "Mall", "Cash", "Shopping");
        purchases[4] = new Purchase("55", "10/10/14", "Somewhere", "Debit", "Other");
        purchases[5] = new Purchase("67", "10/10/15", "Online", "Cash", "Bills");
        purchases[6] = new Purchase("23", "10/10/16", "PandaExpress", "Cash", "Food");
        purchases[7] = new Purchase("34", "10/10/17", "GasStation", "Credit", "Gas");
        purchases[8] = new Purchase("98", "10/10/18", "BestBuy", "Cash", "Entertainment");
        purchases[9] = new Purchase("87", "10/10/19", "Target", "Cash", "Shopping");
        purchases[10] = new Purchase("76", "10/10/20", "Somewhere", "Debit", "Other");
        purchases[11] = new Purchase("123", "10/10/21", "Online", "Cash", "Bills");
        purchases[12] = new Purchase("14", "10/10/22", "TacoBell", "Cash", "Food");
        purchases[13] = new Purchase("34", "10/10/23", "Somewhere", "Credit", "Gas");
        purchases[14] = new Purchase("19", "10/10/24", "Somewhere", "Cash", "Entertainment");
        purchases[15] = new Purchase("200", "10/10/25", "Mall", "Cash", "Shopping");
        purchases[16] = new Purchase("35", "10/10/26", "Somewhere", "Debit", "Other");
        purchases[17] = new Purchase("200", "10/10/27", "Online", "Cash", "Bills");
        for(int i = 0; i < purchases.length; i++){
            fileIOTest.addPurchase(purchases[i]);
        }

        Purchase[] test = fileIOTest.getPurchases();
        for(int i = 0; i < test.length; i++){
            testbool = ( testbool &&  purchases[i].getPrice().equals(test[i].getPrice()) && purchases[i].getMethod().equals(test[i].getMethod()) &&
            purchases[i].getLocation().equals(test[i].getLocation()) && purchases[i].getDate().equals(test[i].getDate()) && purchases[i].getCategory().equals(test[i].getCategory()));
            Log.i("TEST ", purchases[i].getPrice() + " =? " + test[i].getPrice() + " : " + purchases[i].getPrice().equals(test[i].getPrice()));
            Log.i("TEST ", purchases[i].getMethod() + " =? " + test[i].getMethod() + " : " + purchases[i].getMethod().equals(test[i].getMethod()));
            Log.i("TEST ", purchases[i].getLocation() + " =? " + test[i].getLocation() + " : " + purchases[i].getLocation().equals(test[i].getLocation()));
            Log.i("TEST ", purchases[i].getDate() + " =? " + test[i].getDate() + " : " + purchases[i].getDate().equals(test[i].getDate()));
            Log.i("TEST ", purchases[i].getCategory() + " =? " + test[i].getCategory() + " : " + purchases[i].getCategory().equals(test[i].getCategory()));
        }

        Log.i("TEST ", "Purchases done; All came back: " + testbool);
        Log.i("TEST ", "");

        Goal[] goals = new Goal[4];
        goals[0] = new Goal("Gas", 500);
        goals[1] = new Goal("SomethingElse", 12);
        goals[2] = new Goal("Bills", 4500);
        goals[3] = new Goal("Other", 100);
        for(int i = 0; i < goals.length; i++){
            fileIOTest.addGoal(goals[i]);
        }

        Goal[] test2 = fileIOTest.getGoals();
        for(int i = 0; i < test2.length; i++){
            testbool = (testbool && test2[i].getCategory().equals(goals[i].getCategory()));
            testbool = (testbool && (goals[i].getSpendingAmount() == test2[i].getSpendingAmount()));
            Log.i("TEST ", goals[i].getCategory() + " =? " + test2[i].getCategory() + " : " + testbool);
            Log.i("TEST ", goals[i].getSpendingAmount() + " =? " + test2[i].getSpendingAmount() + " : " + testbool);
        }
        Log.i("TEST ", "Goals done; All came back: " + testbool);
        Log.i("TEST ", "");


        Category[] categories = new Category[2];
        categories[0] = new Category("Something");
        categories[0] = new Category("SomethingElse");



    }

}
