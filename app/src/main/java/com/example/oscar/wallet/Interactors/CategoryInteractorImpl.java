package com.example.oscar.wallet.Interactors;

import com.example.oscar.wallet.Interfaces.InterfacesInteractors.CategoryInteractor;
import com.example.oscar.wallet.Interfaces.InterfacesListeners.OnListenerFinishCategory;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Models.Category;
import com.example.oscar.wallet.Views.App;

import java.util.ArrayList;

/**
 * Created by oscar on 31/12/2017.
 */

public class CategoryInteractorImpl implements CategoryInteractor {

    @Override
    public void getCategories(OnListenerFinishCategory listener) {
        ArrayList<Category> categories = App.db.categoryDao.getAllCategories();
        if(categories!= null){
            listener.setCategories(categories);
        }
    }

    @Override
    public void getExpensesCategories(OnListenerFinishCategory listener) {
        ArrayList<Category> categoriesAllList = App.db.categoryDao.getAllCategories();
        ArrayList<Category> expensesCategoriesList= new ArrayList<>();
        if(categoriesAllList!=null){
            for (Category category: categoriesAllList) {
                if(category.getTypeCategory().equals("Expense"))
                {
                    expensesCategoriesList.add(category);
                }
            }
            listener.setCategories(expensesCategoriesList);
        }
    }

    @Override
    public void getIncomeCategories(OnListenerFinishCategory listener) {
        ArrayList<Category> categoriesAllList = App.db.categoryDao.getAllCategories();
        ArrayList<Category> incomeCategoriesList= new ArrayList<>();
        if(categoriesAllList != null){
            for (Category category: categoriesAllList) {
                if(category.getTypeCategory().equals("Incoming"))
                {
                    incomeCategoriesList.add(category);
                }
            }
            listener.setCategories(incomeCategoriesList);
        }
    }
}
