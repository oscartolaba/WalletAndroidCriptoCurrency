package com.example.oscar.wallet.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;

import com.example.oscar.wallet.DB.WalletContract.Accounts;

/**
 * Created by oscar on 2/12/2017.
 */

public class DataBaseWallet extends SQLiteOpenHelper {
   private  static String DATA_BASE_NAME= "Wallet";
   private static int VERSION_ACTUAL=1;
   private final Context context;

    public DataBaseWallet(Context context) {
        super(context, DATA_BASE_NAME, null, VERSION_ACTUAL);
        this.context=context;
    }

    public interface Tables {
        String ACCOUNT = "account";
        String CATEGORY = "category";
        String OPERATION = "operation";

    }
   public interface References {

        String ID_ACCOUNT = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tables.ACCOUNT, WalletContract.Accounts.ID);

        String ID_CATEGORY = String.format("REFERENCES %s(%s)",
                Tables.CATEGORY, WalletContract.Categories.ID);

        String ID_OPERATION = String.format("REFERENCES %s(%s)",
                Tables.OPERATION, WalletContract.Operations.ID);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT UNIQUE NOT NULL,%s TEXT UNIQUE NOT NULL,%s REAL NOT NULL %s," +
                        "%s TEXT NOT NULL %s)", Tables.ACCOUNT, BaseColumns._ID,
                  Accounts.ID, Accounts.TITLE,
                Accounts.AMOUNT,Accounts.ACCOUNT_TYPE));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT UNIQUE NOT NULL,%s TEXT UNIQUE NOT NULL,%s REAL NOT NULL %s," +
                        "%s TEXT NOT NULL %s)", Tables.OPERATION, BaseColumns._ID,
                WalletContract.Operations.ID, WalletContract.Operations.AMOUNT, WalletContract.Operations.DATE,
                WalletContract.Operations.OPERATION_TYPE,References.ID_ACCOUNT,References.ID_CATEGORY, WalletContract.Operations.DESCRIPCION));

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT UNIQUE NOT NULL,%s TEXT UNIQUE NOT NULL)",
                Tables.CATEGORY, BaseColumns._ID,
                WalletContract.Categories.ID, WalletContract.Categories.DESCRIPTION));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Tables.ACCOUNT);
        db.execSQL("DROP TABLE IF EXISTS " + Tables.OPERATION);
        db.execSQL("DROP TABLE IF EXISTS " + Tables.CATEGORY);

        onCreate(db);
    }
}
