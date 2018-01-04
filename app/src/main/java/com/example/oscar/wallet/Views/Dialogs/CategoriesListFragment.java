package com.example.oscar.wallet.Views.Dialogs;


import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.oscar.wallet.Di.Components.DaggerAccountListComponent;
import com.example.oscar.wallet.Di.Components.DaggerCategoryListComponent;
import com.example.oscar.wallet.Di.Modules.AccountListModule;
import com.example.oscar.wallet.Di.Modules.CategoryModule;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerSelectedCategory;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.CategoryPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.CategoryListView;
import com.example.oscar.wallet.Models.Category;
import com.example.oscar.wallet.R;
import com.example.oscar.wallet.Views.App;
import com.example.oscar.wallet.Views.AppComponent;


import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 */
public class CategoriesListFragment extends DialogFragment implements Toolbar.OnMenuItemClickListener,CategoryListView{

        @BindView(R.id.listview_categories)
        ListView listViewCategories;

        OnListenerSelectedCategory result;

        @Inject
        CategoryPresenter presenter;

    public CategoriesListFragment() {
setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_categories_list,container,false);
         ButterKnife.bind(this,view);
        DaggerCategoryListComponent.builder()
                .appComponent(((App)getActivity().getApplicationContext()).getAppComponent())
                .categoryModule(new CategoryModule(this))
                .build()
                .inject(this);
         Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_fragment);
         toolbar.inflateMenu(R.menu.menu_category);
         toolbar.setOnMenuItemClickListener(this);
         result = (OnListenerSelectedCategory) getActivity();
          presenter.getCategories();

         return view;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_new_category:
                showNewCategoryFragment();break;
                default:
                    return false;
        }
        return true;
    }

    private void showNewCategoryFragment(){
        FragmentTransaction fragmentTransaction= getFragmentManager().beginTransaction();
        Fragment prev= getFragmentManager().findFragmentByTag("newCategoryDialog");
        if(prev != null){
            fragmentTransaction.remove(prev);
        }
        CategoryFragment categoryFragment= new CategoryFragment();
        dismiss();
        categoryFragment.show(fragmentTransaction,"newCategoryDialog");
    }

   @OnItemClick(R.id.listview_categories)
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Category category= (Category)adapterView.getItemAtPosition(i);
        result.setSelectedCategory(category);
        dismiss();
    }

    @Override
    public void setCategoriesListView(ArrayList<Category> categories) {
        ArrayAdapter<Category> adapter= new ArrayAdapter<Category>(getActivity(),android.R.layout.simple_list_item_1,categories);
        listViewCategories.setAdapter(adapter);
    }
}
