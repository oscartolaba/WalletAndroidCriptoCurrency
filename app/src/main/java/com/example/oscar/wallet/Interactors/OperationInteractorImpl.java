package com.example.oscar.wallet.Interactors;

import android.content.Context;
import android.database.Cursor;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.OperationInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishOperation;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Views.App;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by oscar on 30/12/2017.
 */

public class OperationInteractorImpl implements OperationInteractor {


    @Override
    public void getAccounts(OnListenerFinishOperation listener) {
        ArrayList<Account> accounts = App.db.accountDao.getAllAccount();
        if(accounts!= null){
            listener.setAccounts(accounts);
        }
    }
}
