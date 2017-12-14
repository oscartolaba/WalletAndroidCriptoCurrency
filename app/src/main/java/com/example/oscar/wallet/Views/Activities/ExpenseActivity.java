package com.example.oscar.wallet.Views.Activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.oscar.wallet.R;


public class ExpenseActivity extends AppCompatActivity {

    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //AppBarLayout
        AppBarLayout appBarLayout =(AppBarLayout)findViewById(R.id.app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(menu != null){
                    MenuItem settingItem= menu.findItem(R.id.action_save);
                    MenuItem photoItem= menu.findItem(R.id.action_photo);
                    MenuItem cameraItem= menu.findItem(R.id.action_camera);
                    //Collapsed
                    if(Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()){
                        settingItem.setVisible(true);
                        photoItem.setVisible(false);
                        cameraItem.setVisible(false);
                    }else
                    {
                        //Expanded
                        if(verticalOffset == 0){
                            settingItem.setVisible(false);
                            photoItem.setVisible(true);
                            cameraItem.setVisible(true);
                        }
                    }}
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_operation,menu);
        this.menu=menu;
        return  true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
