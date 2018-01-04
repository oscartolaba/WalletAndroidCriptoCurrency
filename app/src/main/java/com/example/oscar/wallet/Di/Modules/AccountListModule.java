package com.example.oscar.wallet.Di.Modules;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.AccountInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountListView;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountNewView;
import com.example.oscar.wallet.Presenters.AccountPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oscar on 24/12/2017.
 */
@Module
public class AccountListModule {
    private AccountListView accountListView;


    public AccountListModule(AccountListView view) {
        this.accountListView = view;
    }


    @Provides
    public AccountListView provideAccountListView(){
        return accountListView;
    }

    @Provides
    public AccountPresenter providePresenter(AccountListView view, AccountInteractor interactor){
        return new AccountPresenterImpl(view,interactor);
    }

}
