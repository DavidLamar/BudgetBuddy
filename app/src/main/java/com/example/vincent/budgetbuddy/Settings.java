package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vincent.budgetbuddy.R;



public class Settings extends AppCompatActivity {

    private FileIO fio;
    private RatingBar ratingBar;
    private TextView txtRatingValue;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fio = new FileIO(this);
        setContentView(R.layout.activity_settings_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addListenerOnRatingBar();
        addListenerOnButton();

    }

    public void deleteUserData(View view){
        fio.clearAllUserData();
        Toast.makeText(getApplicationContext(), "User data has been cleared", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), BudgetBuddy.class));
    }


    public void selectHome(View v){
        Button button = (Button)v;
        startActivity(new Intent(getApplicationContext(), BudgetBuddy.class));
    }

    public void selectAbout(View v){
        Button button = (Button)v;
        startActivity(new Intent(getApplicationContext(), About.class));
    }

    public void deletePurchases(View v){
        FileIO fio = new FileIO(this);
        fio.deletePurchase();
        Toast.makeText(getApplicationContext(), "Deleted all user purchases", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), BudgetBuddy.class));
    }

    public void viewPurchases(View v){
        startActivity(new Intent(getApplicationContext(), purchase_history.class));
    }

    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        //txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                //txtRatingValue.setText(String.valueOf(rating));

            }
        });
    }

    public void addListenerOnButton() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.RateUs);

        //if click on me, then display the current rating value.
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();

            }

        });

    }


}
