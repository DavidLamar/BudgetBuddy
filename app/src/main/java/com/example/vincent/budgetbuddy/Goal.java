package com.example.vincent.budgetbuddy;

/**
 * Created by David on 2/17/2016.
 */
public class Goal {

    private String category;
    private double spendingAmount;


    public Goal(String category, double spendingAmount){
        this.category = category;
        this.spendingAmount = spendingAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getSpendingAmount() {
        return spendingAmount;
    }

    public void setSpendingAmount(double spendingAmount) {
        this.spendingAmount = spendingAmount;
    }
}
