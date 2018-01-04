package com.example.oscar.wallet.Di.Modules;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.AccountInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishAccount;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountListView;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountNewView;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Presenters.AccountPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by oscar on 16/12/2017.
 */

@Module
public class AccountModule {

    private AccountNewView accountNewView;

    public AccountModule(AccountNewView view) {
        this.accountNewView = view;
    }

    @Provides
    public AccountNewView provideAccountNewView(){
        return accountNewView;
    }

    @Provides
    public AccountPresenter providePresenter(AccountNewView view, AccountInteractor interactor){
        return new AccountPresenterImpl(view,interactor);
    }
    @Provides
    public Account provideAccount(){
        return  new Account();
    }


}
