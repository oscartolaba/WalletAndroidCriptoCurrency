package com.example.oscar.wallet.Views.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.example.oscar.wallet.Models.Category;

import java.util.ArrayList;

/**
 * Created by oscar on 31/12/2017.
 */

public class CategoryAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<Category> categoriesList;
    private ArrayList<Category>  searchList;


    public CategoryAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }
}
