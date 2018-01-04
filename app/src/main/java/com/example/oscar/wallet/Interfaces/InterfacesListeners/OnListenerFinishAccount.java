package com.example.oscar.wallet.Interfaces.InterfacesListeners;

import com.example.oscar.wallet.Models.Account;

import java.util.ArrayList;

/**
 * Created by oscar on 8/12/2017.
 */

public interface OnListenerFinishAccount {
    public void setErrorAmount();
    public void setErrorTitle();
    public void operatioSucceseful();
    public void setErrorTitleVeryShort();
    public void setAccounts(ArrayList<Account> accounts);
}
