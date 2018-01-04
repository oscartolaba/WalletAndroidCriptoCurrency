package com.example.oscar.wallet.Di.Components;

import com.example.oscar.wallet.Di.FragmentScope;
import com.example.oscar.wallet.Di.Modules.CategoryModule;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.CategoryPresenter;
import com.example.oscar.wallet.Views.AppComponent;
import com.example.oscar.wallet.Views.Dialogs.CategoriesListFragment;
import com.example.oscar.wallet.Views.Fragments.CategoryExpenseFragment;

import dagger.Component;

/**
 * Created by oscar on 4/1/2018.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules=CategoryModule.class)
public interface ExpenseCategoryComponent {

    void inject(CategoryExpenseFragment fragment);
    CategoryPresenter getPresenter();
}
