package com.example.oscar.wallet.Interfaces.InterfacesViews;

import com.example.oscar.wallet.Models.Account;

import java.util.ArrayList;

/**
 * Created by oscar on 24/12/2017.
 */

public interface AccountListView {
    public void showThereAreNotAccounts();
    public void showAccounts(ArrayList<Account> accounts);
}
