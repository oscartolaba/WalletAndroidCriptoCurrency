package com.example.oscar.wallet.Interfaces.InterfacesInteractors;

import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishAccount;

/**
 * Created by oscar on 8/12/2017.
 */

public interface AccountInteractor {

    public void insertAccount(Account account,OnListenerFinishAccount listener);
     public void getAccounts(OnListenerFinishAccount listener);
}
