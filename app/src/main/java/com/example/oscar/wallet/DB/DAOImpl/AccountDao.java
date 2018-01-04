package com.example.oscar.wallet.DB.DAOImpl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.oscar.wallet.DB.DAO.IAccountDao;
import com.example.oscar.wallet.DB.Providers.DbContentProvider;
import com.example.oscar.wallet.DB.Schemas.IAccountSchema;
import com.example.oscar.wallet.Models.Account;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by oscar on 31/12/2017.
 */

public class AccountDao extends DbContentProvider implements IAccountDao,IAccountSchema {
     private Cursor cursor;
     private ContentValues initialValues;

    public AccountDao(SQLiteDatabase mDb) {
        super(mDb);
    }

    @Override
    protected Account cursorToEntity(Cursor cursor) {
      Account account= new Account();
      int idIndex,titleIndex,amountIndex;
      if(cursor!=null){
          if(cursor.getColumnIndex(COLUMN_ID)!=-1){
              idIndex= cursor.getColumnIndexOrThrow(COLUMN_ID);
              account.setId(cursor.getInt(idIndex));
          }
          if(cursor.getColumnIndex(COLUMN_TITLE)!=-1){
              titleIndex= cursor.getColumnIndexOrThrow(COLUMN_TITLE);
              account.setTitle(cursor.getString(titleIndex));
          }
          if(cursor.getColumnIndex(COLUMN_AMOUNT)!=-1){
              amountIndex= cursor.getColumnIndexOrThrow(COLUMN_AMOUNT);
              account.setAmount(new BigDecimal(cursor.getString(amountIndex)));
          }
      }
        return account;
    }

    @Override
    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> accounts= new ArrayList<>();
        cursor= super.query(ACCOUNT_TABLE,ACCOUNT_COLUMNS,null,null,COLUMN_TITLE);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Account account= cursorToEntity(cursor);
                accounts.add(account);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return accounts;
    }

    @Override
    public boolean addAccount(Account account) {
       setContentValue(account);
       try{
           return super.insert(ACCOUNT_TABLE,getContentValue())>0;
       }catch (SQLiteConstraintException ex){
           Log.w("DataBase",ex.getMessage());
           return false;
       }
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }

    @Override
    public boolean deleteAccount(int id) {
        return false;
    }
    private void setContentValue(Account account){
        initialValues = new ContentValues();
        initialValues.put(COLUMN_TITLE,account.getTitle());
        initialValues.put(COLUMN_AMOUNT, String.valueOf(account.getAmount()));
    }
    private ContentValues getContentValue(){
        return initialValues;
    }
}
