package com.example.oscar.wallet.Interactors;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.AccountInteractor;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishAccount;
import com.example.oscar.wallet.Views.App;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by oscar on 8/12/2017.
 */

public class AccountInteractorImpl implements AccountInteractor {

    @Override
    public void insertAccount(Account account,OnListenerFinishAccount listener) {
        if(!account.getTitle().isEmpty() && !account.getAmount().toString().isEmpty()){
            if(account.getTitle().length()>=3){
                boolean operationSuccesful = App.db.accountDao.addAccount(account);
                if(operationSuccesful){
                    listener.operatioSucceseful();
                }
            }else{
                listener.setErrorTitleVeryShort();
            }

        }else{
            if(account.getTitle().isEmpty()){
                listener.setErrorTitle();
            }
            if (account.getAmount() == null){
                listener.setErrorAmount();
            }

        }
    }

    @Override
    public void getAccounts(OnListenerFinishAccount listener) {
       ArrayList<Account> accounts = App.db.accountDao.getAllAccount();
       if(accounts!= null){
           listener.setAccounts(accounts);
       }
    }

}
