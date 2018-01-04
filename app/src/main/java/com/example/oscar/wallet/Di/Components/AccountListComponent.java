package com.example.oscar.wallet.Di.Components;

import com.example.oscar.wallet.Di.ActivityScope;
import com.example.oscar.wallet.Di.Modules.AccountListModule;
import com.example.oscar.wallet.Di.Modules.AccountModule;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Views.Activities.AccountListActivity;
import com.example.oscar.wallet.Views.Activities.AccountNewActivity;
import com.example.oscar.wallet.Views.AppComponent;

import dagger.Component;

/**
 * Created by oscar on 24/12/2017.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules=AccountListModule.class)
public interface AccountListComponent {
    void inject(AccountListActivity activity);
    AccountPresenter getPresenter();
}
