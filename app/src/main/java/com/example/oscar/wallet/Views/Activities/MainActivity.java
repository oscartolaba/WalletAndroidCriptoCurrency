package com.example.oscar.wallet.Views.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oscar.wallet.R;

public class MainActivity extends AppCompatActivity {

    public Button btnAccount,btnIncoming, btnExpense;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAccount=(Button)findViewById(R.id.btn_navigate_account);
        btnIncoming=(Button)findViewById(R.id.btn_navigate_incoming);
        btnExpense=(Button)findViewById(R.id.btn_navigate_expense);

    }

    public void navigate_account(View v){
        startActivity(new Intent(this,AccountNewActivity.class));
    }

    public void navigate_incoming(View v){
        startActivity(new Intent(this,IncomingActivity.class));
    }

    public void navigate_expense(View v){
        startActivity(new Intent(this,ExpenseActivity.class));
    }
}
