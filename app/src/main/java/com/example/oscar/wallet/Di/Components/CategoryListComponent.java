package com.example.oscar.wallet.Di.Components;

import com.example.oscar.wallet.Di.ActivityScope;
import com.example.oscar.wallet.Di.FragmentScope;
import com.example.oscar.wallet.Di.Modules.AccountListModule;
import com.example.oscar.wallet.Di.Modules.CategoryModule;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.CategoryPresenter;
import com.example.oscar.wallet.Views.AppComponent;
import com.example.oscar.wallet.Views.Dialogs.CategoriesListFragment;

import dagger.Component;

/**
 * Created by oscar on 31/12/2017.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules=CategoryModule.class)
public interface CategoryListComponent {
    void inject(CategoriesListFragment fragment);

    CategoryPresenter getPresenter();
}
