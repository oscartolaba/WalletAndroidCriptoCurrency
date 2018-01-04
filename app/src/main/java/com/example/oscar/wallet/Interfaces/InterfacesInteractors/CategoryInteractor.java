package com.example.oscar.wallet.Interfaces.InterfacesInteractors;

import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishCategory;

/**
 * Created by oscar on 31/12/2017.
 */

public interface CategoryInteractor {

    public  void getCategories(OnListenerFinishCategory listener);
    public void getExpensesCategories(OnListenerFinishCategory listener);
    public void getIncomeCategories(OnListenerFinishCategory listener);

}
