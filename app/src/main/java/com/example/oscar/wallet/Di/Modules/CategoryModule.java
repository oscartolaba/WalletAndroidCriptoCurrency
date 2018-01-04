package com.example.oscar.wallet.Di.Modules;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.AccountInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.CategoryInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.CategoryPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountNewView;
import com.example.oscar.wallet.Interfaces.InterfacesViews.CategoryListView;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Presenters.AccountPresenterImpl;
import com.example.oscar.wallet.Presenters.CategoryPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oscar on 31/12/2017.
 */

@Module
public class CategoryModule {

    private CategoryListView view;

    public CategoryModule(CategoryListView view) {
        this.view = view;
    }

    @Provides
    public CategoryListView provideCategoryListView(){
        return view;
    }

    @Provides
    public CategoryPresenter providePresenter(CategoryListView view, CategoryInteractor interactor){
        return new CategoryPresenterImpl(view,interactor);
    }

}
