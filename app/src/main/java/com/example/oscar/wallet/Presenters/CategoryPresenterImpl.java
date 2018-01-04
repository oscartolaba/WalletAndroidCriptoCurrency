package com.example.oscar.wallet.Presenters;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.CategoryInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishCategory;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.CategoryPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.CategoryListView;
import com.example.oscar.wallet.Models.Category;

import java.util.ArrayList;

/**
 * Created by oscar on 31/12/2017.
 */

public class CategoryPresenterImpl implements CategoryPresenter,OnListenerFinishCategory {
    private  CategoryListView view;
     private CategoryInteractor interactor;

    public CategoryPresenterImpl(CategoryListView view, CategoryInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void getCategories() {
        if(interactor!=null){
            interactor.getCategories(this);
        }
    }

    @Override
    public void setCategories(ArrayList<Category> categories) {
       if(view!=null){
           view.setCategoriesListView(categories);
       }
    }
}
