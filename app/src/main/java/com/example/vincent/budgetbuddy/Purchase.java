package com.example.vincent.budgetbuddy;

/**
 * Created by David on 2/16/2016.
 */
public class Purchase {

    private String price;
    private String date;
    private String location;
    private String method;
    private String category;

    public Purchase(String price, String date, String location, String method, String category){
        this.price = price;
        this.date = date;
        this.location = location;
        this.method = method;
        this.category = category;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
