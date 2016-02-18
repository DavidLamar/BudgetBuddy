package com.example.vincent.budgetbuddy;

/**
 * Created by David on 2/17/2016.
 */
public class Goal {

    private Category category;
    private double spendingAmount;


    public Goal(Category category, double spendingAmount){
        this.category = category;
        this.spendingAmount = spendingAmount;
    }
}
