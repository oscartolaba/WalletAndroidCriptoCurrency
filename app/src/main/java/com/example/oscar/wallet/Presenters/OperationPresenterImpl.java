package com.example.oscar.wallet.Presenters;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.AccountInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesInteractors.OperationInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishAccount;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishOperation;
import com.example.oscar.wallet.Interfaces.InterfacesPresenters.OperationPresenter;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountListView;
import com.example.oscar.wallet.Interfaces.InterfacesViews.AccountNewView;
import com.example.oscar.wallet.Interfaces.InterfacesViews.OperationView;
import com.example.oscar.wallet.Models.Account;

import java.util.ArrayList;

/**
 * Created by oscar on 30/12/2017.
 */

public class OperationPresenterImpl implements OperationPresenter,OnListenerFinishOperation {

    OperationView operationView;
    OperationInteractor  operationInteractor;

    public OperationPresenterImpl(OperationView view,OperationInteractor operationInteractor) {
        this.operationView = view;
        this.operationInteractor= operationInteractor;
    }

    @Override
    public void getAccounts() {
        if(operationInteractor!= null){
            operationInteractor.getAccounts(this);
        }
    }

    @Override
    public void setAccounts(ArrayList<Account> accounts) {
         if(operationView != null){
             operationView.setAccountsAdapter(accounts);
         }
    }
}
