package com.example.oscar.wallet.DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.oscar.wallet.DB.Domain.Account;
import com.example.oscar.wallet.DB.WalletContract.Accounts;
/**
 * Created by oscar on 7/12/2017.
 */

public class OperationsDB {

    private static DataBaseWallet dataBase;

    private static OperationsDB instancia = new OperationsDB();

    private OperationsDB() {
    }

    public static OperationsDB getInstance(Context context) {
        if (dataBase == null) {
            dataBase = new DataBaseWallet(context);
        }
        return instancia;
    }

    // [OPERACIONES_CLIENTE]
    public Cursor getAccount() {
        SQLiteDatabase db = dataBase.getReadableDatabase();

        String sql = String.format("SELECT * FROM %s", DataBaseWallet.Tables.ACCOUNT);

        return db.rawQuery(sql, null);
    }

    public String insertAccount(Account account) {
        SQLiteDatabase db = dataBase.getWritableDatabase();

        // Generar Pk
        String idAccount= Accounts.generateIdAccount();

        ContentValues values = new ContentValues();
        values.put(Accounts.ID, idAccount);
        values.put(Accounts.TITLE,account.getTitle());
        values.put(Accounts.AMOUNT, String.valueOf(account.getAmount()));
        values.put(Accounts.ACCOUNT_TYPE, account.getTypeAccount());

        return db.insertOrThrow(DataBaseWallet.Tables.ACCOUNT, null, values) > 0 ? idAccount : null;
    }

    public boolean actualizarCliente(Account account) {
        SQLiteDatabase db = dataBase.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Accounts.ID, account.getId());
        values.put(Accounts.TITLE,account.getTitle());
        values.put(Accounts.AMOUNT, String.valueOf(account.getAmount()));
        values.put(Accounts.ACCOUNT_TYPE, account.getTypeAccount());

        String whereClause = String.format("%s=?", Accounts.ID);
        final String[] whereArgs = {String.valueOf(account.getId())};

        int resultado = db.update(DataBaseWallet.Tables.ACCOUNT, values, whereClause, whereArgs);

        return resultado > 0;
    }

    public boolean deleteAccount(String idAccount) {
        SQLiteDatabase db = dataBase.getWritableDatabase();

        String whereClause = String.format("%s=?", Accounts.ID);
        final String[] whereArgs = {idAccount};

        int resultado = db.delete(DataBaseWallet.Tables.ACCOUNT, whereClause, whereArgs);

        return resultado > 0;
    }

}

