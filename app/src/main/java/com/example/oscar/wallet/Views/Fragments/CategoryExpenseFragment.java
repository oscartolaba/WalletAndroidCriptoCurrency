package com.example.oscar.wallet.Views.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.oscar.wallet.Di.Components.DaggerCategoryListComponent;
import com.example.oscar.wallet.Di.Modules.CategoryModule;
import com.example.oscar.wallet.R;
import com.example.oscar.wallet.Views.App;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oscar on 31/12/2017.
 */

public class CategoryExpenseFragment extends Fragment {
    public static final String TITLE= "Gastos";

    @BindView(R.id.listview_expenses_categories)
    ListView listViewCategories;


    public static CategoryExpenseFragment newInstance(){
        return  new CategoryExpenseFragment();
    }

    public CategoryExpenseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceBundle){
        View view= inflater.inflate(R.layout.fragment_categories_expense,container,false);
        ButterKnife.bind(this,view);
        DaggerCategoryListComponent.builder()
                .appComponent(((App)getActivity().getApplicationContext()).getAppComponent())
                .categoryModule(new CategoryModule(this))
                .build()
                .inject(this);
        return view;
    }

}
