package com.example.oscar.wallet.Views.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.oscar.wallet.R;
import com.example.oscar.wallet.Views.Adapters.ViewPagerAdapter;

public class CategoryActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setViewPager();
    }
    private void setViewPager(){
        viewPager= (ViewPager)findViewById(R.id.pager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout=(TabLayout)findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }
}
