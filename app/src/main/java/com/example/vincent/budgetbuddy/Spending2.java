package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;

public class Spending2 extends AppCompatActivity {

    private RelativeLayout mainLayout;
    private PieChart mChart;

    //AddPurchase addPurch = new AddPurchase();
    private String[] xData = {"Gas", "Entertainment", "Food,", "Bills", "Shopping", "Other" };

    //make AddPurch protected
    //private String[] xData = addPurch.paths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spending2);

        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);

        mChart = new PieChart(this);
        //add pie chart to main layout
        mainLayout.addView(mChart);
        mainLayout.setBackgroundColor(Color.parseColor("#FFDADADB" +
                ""));

        //configure pie chart
        mChart.setUsePercentValues(true);
        mChart.setDescription("Spending Distribution");
        mChart.setDescriptionTextSize(20f);
        //enable hole and configure
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColorTransparent(true);
        mChart.setHoleRadius(7);
        mChart.setTransparentCircleRadius(10);

        //enable rotation of the chart by touch
        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);

        //set chart value selected listener

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                //display msg when value selected
                if (e == null)
                    return;

                Toast.makeText(Spending2.this, xData[e.getXIndex()]
                        + " = " + e.getVal() + "%", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        //add data
        addData();

        //Customize legened
        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);

    }

    public void addData(){
        int gasProgressStatus = 0;
        int entertainmentProgressStatus = 0;
        int foodProgressStatus = 0;
        int billsProgressStatus = 0;
        int shoppingProgressStatus = 0;
        int otherProgressStatus = 0;

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
        // Adds amount spent in each category to pie chart data
        int[] yData = {gasProgressStatus, entertainmentProgressStatus, foodProgressStatus,
                billsProgressStatus, shoppingProgressStatus, otherProgressStatus};

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for(int i = 0; i < yData.length; i++)
            yVals1.add(new Entry(yData[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for(int i = 0; i < xData.length; i++)
            xVals.add(xData[i]);

        //create Pie data set
        PieDataSet dataSet = new PieDataSet(yVals1, "Spending");
        dataSet.setValueTextSize(16f);
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        //add many colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c: ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c: ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c: ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c: ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c: ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);

        //instantiate pie date object
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        mChart.setData(data);

        //undo all highlights
        mChart.highlightValues(null);

        //update pie chart
        mChart.invalidate();
    }

    /*
    public void selectPieChart(View v){
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId())
        {
            case R.id.graph:
                if(checked){
                    startActivity(new Intent(getApplicationContext(), Spending.class));
                }
                break;

            case R.id.chart:
                if(checked){
                    startActivity(new Intent(getApplicationContext(), Spending2.class));
                }
                break;
        }
    }
    */

}
