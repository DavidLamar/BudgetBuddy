package com.example.vincent.budgetbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vincent.budgetbuddy.R;



public class Settings extends AppCompatActivity {

    private FileIO fio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fio = new FileIO(this);
        setContentView(R.layout.activity_settings_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void deleteUserData(View view){
        fio.clearAllUserData();
        Toast.makeText(getApplicationContext(), "User data has been cleared", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), BudgetBuddy.class));
    }



}
