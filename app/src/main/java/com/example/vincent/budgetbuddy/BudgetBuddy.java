package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

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

        rPurchases = new TextView[3];
        rPurchases[0] = ((TextView) findViewById(R.id.textView3));
        rPurchases[1] = ((TextView) findViewById(R.id.textView4));
        rPurchases[2] = ((TextView) findViewById(R.id.textView5));
        rPurchases[0].setText("");
        rPurchases[1].setText("");
        rPurchases[2].setText("");
        //Handles the recent purchases
        if(file.checkPurchases()){
            Purchase[] tempPurchases = file.getPurchases();
            for(int i = 0; i < 3; i++){
                if(i >= tempPurchases.length){
                    rPurchases[i].setText("");
                } else {
                    rPurchases[i].setText(tempPurchases[tempPurchases.length - (i + 1)].getDate() + " - $" + tempPurchases[tempPurchases.length - (i + 1)].getPrice() + " at: " + tempPurchases[tempPurchases.length - (i + 1)].getLocation());
                }
            }
        } else {
            rPurchases[0].setText("");
            rPurchases[1].setText("");
            rPurchases[2].setText("");
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
        Purchase[] purchases = new Purchase[12];
        purchases[0] = new Purchase("55", "10/10/10", "Somewhere", "Cash", "Food");
        purchases[1] = new Purchase("12", "10/10/11", "Somewhere", "Credit", "Gas");
        purchases[2] = new Purchase("2", "10/10/12", "Somewhere", "Cash", "Entertainment");
        purchases[3] = new Purchase("100", "10/10/13", "Somewhere", "Cash", "Shopping");
        purchases[4] = new Purchase("25", "10/10/14", "Somewhere", "Debit", "Other");
        purchases[5] = new Purchase("60", "10/10/15", "Somewhere", "Cash", "Bills");
        purchases[6] = new Purchase("125", "10/10/10", "Somewhere", "Credit", "Food");
        purchases[7] = new Purchase("44", "10/10/11", "Somewhere", "Credit", "Gas");
        purchases[8] = new Purchase("88", "10/10/12", "Somewhere", "Cash", "Entertainment");
        purchases[9] = new Purchase("30", "10/10/13", "Somewhere", "Cash", "Shopping");
        purchases[10] = new Purchase("57", "10/10/14", "Somewhere", "Debit", "Other");
        purchases[11] = new Purchase("122", "10/10/15", "Somewhere", "Cash", "Bills");
        for(int i = 0; i < purchases.length; i++){
            fileIOTest.addPurchase(purchases[i]);
        }

        Purchase[] test = fileIOTest.getPurchases();
        for(int i = 0; i < test.length; i++){
            testbool = ( testbool &&  purchases[i].getPrice().equals(test[i].getPrice()) && purchases[i].getMethod().equals(test[i].getMethod()) &&
            purchases[i].getLocation().equals(test[i].getLocation()) && purchases[i].getDate().equals(test[i].getDate()) && purchases[i].getCategory().equals(test[i].getCategory()));
            Log.i("TEST ", purchases[i].getPrice() + " =? " + test[i].getPrice() + " : " + testbool);
            Log.i("TEST ", purchases[i].getMethod() + " =? " + test[i].getMethod() + " : " + testbool);
            Log.i("TEST ", purchases[i].getLocation() + " =? " + test[i].getLocation() + " : " + testbool);
            Log.i("TEST ", purchases[i].getDate() + " =? " + test[i].getDate() + " : " + testbool);
            Log.i("TEST ", purchases[i].getCategory() + " =? " + test[i].getCategory() + " : " + testbool);
        }

        Log.i("TEST ", "Purchases done; All came back: " + testbool);
        Log.i("TEST ", " ");

        Goal[] goals = new Goal[8];
        goals[0] = new Goal("Gas", 500);
        goals[1] = new Goal("Shopping", 1000);
        goals[2] = new Goal("Bills", 778);
        goals[3] = new Goal("Food", 1234);
        goals[4] = new Goal("Other", 653);
        goals[5] = new Goal("Entertainment", 1572);
        goals[6] = new Goal("SomethingElse", 4567);
        goals[7] = new Goal("More", 1050);
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
        Log.i("TEST ", " ");

    }

}
