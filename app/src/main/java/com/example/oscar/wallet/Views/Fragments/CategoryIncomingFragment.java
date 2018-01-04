package com.example.oscar.wallet.Views.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.oscar.wallet.R;

import javax.annotation.Nullable;

import butterknife.BindView;

/**
 * Created by oscar on 31/12/2017.
 */

public class CategoryIncomingFragment extends Fragment {
    public static final String TITLE= "Ingresos";


    @BindView(R.id.listview_income_categories)
    ListView listViewCategories;

    public static CategoryExpenseFragment newInstance(){
        return  new CategoryExpenseFragment();
    }

    public CategoryIncomingFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceBundle){
        return inflater.inflate(R.layout.fragment_categories_incoming,container,false);
}
}
