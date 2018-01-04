package com.example.oscar.wallet.DB.DAO;

import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Models.Category;

import java.util.ArrayList;

/**
 * Created by oscar on 31/12/2017.
 */

public interface ICategoryDao {
    public ArrayList<Category> getAllCategories();
    public boolean addCategory(Category category) ;
    public  boolean updateCategory(Category category);
    public  boolean deleteCategory(int id);
}
