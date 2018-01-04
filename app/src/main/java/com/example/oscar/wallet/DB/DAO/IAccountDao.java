package com.example.oscar.wallet.DB.DAO;

import android.database.Cursor;

import com.example.oscar.wallet.Models.Account;

import java.util.ArrayList;


/**
 * Created by OSCAR on 4/12/2016.
 */
public interface IAccountDao {

    public ArrayList<Account> getAllAccount();
    public boolean addAccount(Account account) ;
    public  boolean updateAccount(Account account);
    public  boolean deleteAccount(int id);
    }
