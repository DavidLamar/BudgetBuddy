package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Spending extends AppCompatActivity {

    private RelativeLayout mainLayout;
    private PieChart mChart;
    //private float[] yData = {5, 10, 15, 20, 25};
    private String[] xData = {"Gas", "Entertainment", "Food,", "Bills", "Shopping", "Other"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        mChart = new PieChart(this);
        mainLayout.addView(mChart);
        mainLayout.setBackgroundColor(Color.LTGRAY);

        mChart.setUsePercentValues(true);
        mChart.setDescription("Smartphone Market Shares");

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColorTransparent(true);
        mChart.setHoleRadius(7);
        mChart.setTransparentCircleRadius(10);

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        */

        BarChart chart = (BarChart) findViewById(R.id.chart);

        BarData data = new BarData(xData, getDataSet());
        chart.setData(data);
        chart.setDescription("My Chart");
        chart.animateXY(2000, 2000);
        chart.invalidate();

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        /*
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
        valueSet2.add(v2e6);
        */

        int gasProgressStatus = 0;
        int entertainmentProgressStatus = 0;
        int foodProgressStatus = 0;
        int billsProgressStatus = 0;
        int shoppingProgressStatus = 0;
        int otherProgressStatus = 0;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        FileIO file = new FileIO(this);
        //Reads amount spent in each category from file
        Purchase[] tempPurchaseAmount = file.getPurchases();
        if (tempPurchaseAmount != null)
            for (int i = 0; i < tempPurchaseAmount.length; i++)
                if (tempPurchaseAmount[i].getCategory().equalsIgnoreCase("Gas"))
                    gasProgressStatus += (float) Double.parseDouble(tempPurchaseAmount[i].getPrice());
                    BarEntry v3e1 = new BarEntry(gasProgressStatus, 0); //Gas
                        valueSet1.add(v3e1);

        //ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        //Reads amount spent in each category from file
        Purchase[] tempPurchaseAmount2 = file.getPurchases();
        if (tempPurchaseAmount2 != null)
            for (int i = 0; i < tempPurchaseAmount2.length; i++)
                 if (tempPurchaseAmount2[i].getCategory().equalsIgnoreCase("Entertainment"))
                    entertainmentProgressStatus += (float) Double.parseDouble(tempPurchaseAmount2[i].getPrice());
                    BarEntry v3e2 = new BarEntry(entertainmentProgressStatus, 1); // Entertaiment
                        valueSet1.add(v3e2);

        //ArrayList<BarEntry> valueSet3 = new ArrayList<>();
        //Reads amount spent in each category from file
        Purchase[] tempPurchaseAmount3 = file.getPurchases();
        if (tempPurchaseAmount3 != null)
            for (int i = 0; i < tempPurchaseAmount3.length; i++)
                if (tempPurchaseAmount3[i].getCategory().equalsIgnoreCase("Food"))
                    foodProgressStatus += (float) Double.parseDouble(tempPurchaseAmount3[i].getPrice());
                    BarEntry v3e3 = new BarEntry(foodProgressStatus, 2); // Food
                        valueSet1.add(v3e3);

        //ArrayList<BarEntry> valueSet4 = new ArrayList<>();
        //Reads amount spent in each category from file
        Purchase[] tempPurchaseAmount4 = file.getPurchases();
        if (tempPurchaseAmount4 != null)
            for (int i = 0; i < tempPurchaseAmount4.length; i++)
                if (tempPurchaseAmount4[i].getCategory().equalsIgnoreCase("Bills"))
                    billsProgressStatus += (float) Double.parseDouble(tempPurchaseAmount4[i].getPrice());
                    BarEntry v3e4 = new BarEntry(billsProgressStatus, 3); //Bills
                        valueSet1.add(v3e4);

        //ArrayList<BarEntry> valueSet5= new ArrayList<>();
        //Reads amount spent in each category from file
        Purchase[] tempPurchaseAmount5 = file.getPurchases();
        if (tempPurchaseAmount5 != null)
            for (int i = 0; i < tempPurchaseAmount5.length; i++)
                if (tempPurchaseAmount5[i].getCategory().equalsIgnoreCase("Shopping"))
                    shoppingProgressStatus += (float) Double.parseDouble(tempPurchaseAmount5[i].getPrice());
                    BarEntry v3e5 = new BarEntry(shoppingProgressStatus, 4); // Shopping
                        valueSet1.add(v3e5);

        //ArrayList<BarEntry> valueSet6 = new ArrayList<>();
        Purchase[] tempPurchaseAmount6 = file.getPurchases();
        if (tempPurchaseAmount6 != null)
            for (int i = 0; i < tempPurchaseAmount6.length; i++)
                if (tempPurchaseAmount6[i].getCategory().equalsIgnoreCase("Other"))
                    otherProgressStatus += (float) Double.parseDouble(tempPurchaseAmount6[i].getPrice());
                    BarEntry v3e6 = new BarEntry(otherProgressStatus, 5); // Jun
                        valueSet1.add(v3e6);


        /*
        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Food");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Clothing");
        barDataSet2.setColor(Color.rgb(155, 0, 0));
        */
        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Spending");
        barDataSet1.setColor(Color.rgb(0, 0, 155));
        /*
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Entertainment");
        barDataSet2.setColor(Color.rgb(155, 0, 155));
        BarDataSet barDataSet3 = new BarDataSet(valueSet3, "Food");
        barDataSet3.setColor(Color.rgb(0, 155, 155));
        BarDataSet barDataSet4 = new BarDataSet(valueSet4, "Bills");
        barDataSet4.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet5 = new BarDataSet(valueSet5, "Shopping");
        barDataSet5.setColor(Color.rgb(155, 0, 0));
        BarDataSet barDataSet6 = new BarDataSet(valueSet6, "Other");
        barDataSet6.setColor(Color.rgb(155, 155, 155));
        */

        dataSets = new ArrayList<>();

        dataSets.add(barDataSet1);
        /*
        dataSets.add(barDataSet2);
        dataSets.add(barDataSet3);
        dataSets.add(barDataSet4);
        dataSets.add(barDataSet5);
        dataSets.add(barDataSet6);
        */

        return dataSets;
    }

    /*
    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        for(int i = 0; i < xData.length; i++)
            xAxis.add(xData[i]);

        xAxis.add("Gas");
        xAxis.add("Entertainment");
        xAxis.add("Food");
        xAxis.add("Bills");
        xAxis.add("Shopping");
        xAxis.add("Other");

        return xAxis;
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

    public void selectPieChart(View v){
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId())
        {
            case R.id.graph2:
                if(checked){
                    startActivity(new Intent(getApplicationContext(), Spending.class));
                }
                break;

            case R.id.chart2:
                if(checked){
                    startActivity(new Intent(getApplicationContext(), Spending2.class));
                }
                break;
        }
    }

}
