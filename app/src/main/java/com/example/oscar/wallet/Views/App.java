package com.example.oscar.wallet.Views;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.oscar.wallet.DB.DataBase;
import com.example.oscar.wallet.Models.Category;
import com.example.oscar.wallet.R;

/**
 * Created by oscar on 16/12/2017.
 */

public class App extends Application {

    private AppComponent appComponent;
    public static DataBase db;

    @Override
    public void onCreate(){
        super.onCreate();
        setupGraph();
        db= new DataBase(this);
        db.open();
        saveCategories();
    }

    private void setupGraph() {
    appComponent= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    private void saveCategories(){
        SharedPreferences preferences= getSharedPreferences("Category",Context.MODE_PRIVATE);
        if(!preferences.getBoolean("savedCategories",false))
        {
        String[] categoriesIncoming= getResources().getStringArray(R.array.categories_incoming);
        String[] categoriesExpense= getResources().getStringArray(R.array.categories_expense);
        for (String description:categoriesIncoming) {
            db.categoryDao.addCategory(new Category(description,"Incoming"));
        }
        for (String description:categoriesExpense) {
            db.categoryDao.addCategory(new Category(description,"Expense"));
        }
        }else{
            SharedPreferences.Editor editor= preferences.edit();
            editor.putBoolean("savedCategories",true);
            editor.commit();
        }
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
    public static App getApp(Context context){
        return  (App) context.getApplicationContext();
    }

    @Override
    public void onTerminate() {
        db.close();
        super.onTerminate();

    }
}
