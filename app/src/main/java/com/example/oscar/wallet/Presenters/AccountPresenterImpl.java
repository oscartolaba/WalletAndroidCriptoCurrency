package com.example.oscar.wallet.Presenters;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.AccountInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.AccountPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountListView;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountNewView;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishAccount;

import java.util.ArrayList;

/**
 * Created by oscar on 8/12/2017.
 */

 public class AccountPresenterImpl implements AccountPresenter, OnListenerFinishAccount {
   AccountNewView accountNewView;
   AccountListView accountListView;
   AccountInteractor interactor;

    public AccountPresenterImpl(AccountNewView view, AccountInteractor interactor) {
        this.accountNewView = view;
        this.interactor=interactor;
    }

    public AccountPresenterImpl(AccountListView view, AccountInteractor interactor) {
        this.accountListView = view;
        this.interactor=interactor;
    }

    @Override
    public void insertAccount(Account account) {
               if(account!= null){
                   interactor.insertAccount(account,this);
    }
    }

    @Override
    public void getAccounts() {
        if(interactor!= null){
            interactor.getAccounts(this);
        }
    }

    @Override
    public void setErrorAmount() {
           if(accountNewView!=null){
               accountNewView.setErrorAmount();
           }
    }

    @Override
    public void setErrorTitle() {
          if(accountNewView != null){
              accountNewView.setErrorTitle();
          }
    }

    @Override
    public void operatioSucceseful() {
           if (accountNewView!= null){
               accountNewView.navigateToHome();
           }
    }

    @Override
    public void setErrorTitleVeryShort() {
        if (accountNewView!= null){
            accountNewView.setErrorTitleVeryShort();
        }
    }

    @Override
    public void setAccounts(ArrayList<Account> accounts) {
        if(accountListView!= null){
            accountListView.showAccounts(accounts);
        }
    }
}
