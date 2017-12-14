package com.example.oscar.wallet.Interfaces;

import com.example.oscar.wallet.DB.Domain.Account;

/**
 * Created by oscar on 8/12/2017.
 */

public interface AccountInteractor {

    public void insertAccount(Account account, OnListenerFinishAccount listener);

}
