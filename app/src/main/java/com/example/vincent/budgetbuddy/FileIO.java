package com.example.vincent.budgetbuddy;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by David on 2/17/2016.
 */
public class FileIO {

    /* These are the names of the files in which our info is being saved*/
    public static final String PURCHASE_OUTPUT = "purchase_data.txt";
    public static final String GOAL_OUTPUT = "goal_data.txt";
    public static final String CATEGORY_OUTPUT = "category_data.txt";

    /* This is the activity in which FileIO is being used in*/
    private AppCompatActivity activity;


    /**
     * Constructor for the FileIO class; Gives file saving/loading functionality
     *
     * @param activity The activity in which FileIO is being used in
     */
    public FileIO(AppCompatActivity activity){
        this.activity = activity;
    }


    /**
     * Gets the saved purchases from the purchase data file
     *
     * @return All of the purchases in the form of an array
     */
    public Purchase[] getPurchases(){
        File file = new File(activity.getFilesDir(), PURCHASE_OUTPUT);
        Purchase[] purchases;
        FileInputStream fis;

        //We need to load in the text file first, so that it doesn't all get deleted
        try {
            fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String[] s = br.readLine().split("-");
            purchases = new Purchase[s.length];
            for (int i = 0; i < s.length; i++) {
                String[] args = s[i].split(" ");
                purchases[i] = new Purchase(args[0], args[1], args[2], args[3], args[4]);
            }
            fis.close();

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Adds a purchase to the purchase data file
     *
     * @param p The purchase we want to save to the file
     */
    public void addPurchase(Purchase p){
        try {
            File file = new File(activity.getFilesDir(), PURCHASE_OUTPUT);
            String saveText = p.getPrice() + " " + p.getMethod() + " " + p.getDate() + " " + p.getLocation() + " " + p.getCategory() + "-";
            ArrayList<String> lines = new ArrayList<String>();
            FileOutputStream fos;
            FileInputStream fis;

            try {
                //We need to load in the text file first, so that it doesn't all get deleted
                fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                lines = new ArrayList<String>();
                String[] s = br.readLine().split("-");
                Log.i("File ", "____________________Loading text file...__________________________");
                for(int i = 0; i < s.length; i++){
                    lines.add(s[i] + "-");
                    Log.i("File ", "Loading: " + s[i]);
                }
                fis.close();
            } catch (Exception e) {
                Log.i("File", "No file");
            }

            lines.add(saveText);

            try {
                //Then write all of our stuff back to the file. This will get a lot slower
                //as more files are added. But that will only be after thousands of entries.
                fos = new FileOutputStream(file);
                for(int i = 0; i < lines.size(); i++){
                    fos.write(lines.get(i).getBytes());
                }
                Log.i("File", "Saving: " + saveText);
                fos.close();

            } catch (Exception e){
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Deletes a purchase at index; The index is the the order in which the purchases were made
     *
     * @param index The index of the purchase being deleted
     */
    public void deletePurchase(int index){

    }

    public void deletePurchase(){

    }

    /**
     * Returns an array containing all of the saved categories from the category data file
     *
     * @return An array containing all of the saved categories
     */
    public Category[] getCategories(){
        return null;
    }

    /**
     * Adds a category to the category data file
     *
     * @param c The category that we are saving to the data file
     */
    public void addCategory(Category c){

    }

    public void deleteCategory(int index){

    }

    public void deleteCategory(String name){

    }


    /**
     * Gets all of the goals from the goals data file
     *
     * @return An array of goals containing all of the goals of the goals data file
     */
    public Goal[] getGoals(){
        return null;
    }

    /**
     * Adds a goal to the goals data file
     *
     * @param g The goal we are adding to the goals data file
     */
    public void addGoal(Goal g){

    }

    public void deleteGoal(int index){

    }

    public void deleteGoal(String name){

    }
}
