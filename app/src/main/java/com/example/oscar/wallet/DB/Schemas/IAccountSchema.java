package com.example.oscar.wallet.DB.Schemas;

/**
 * Created by oscar on 31/12/2017.
 */

public interface IAccountSchema {
    String ACCOUNT_TABLE="Account";
    String COLUMN_ID="id";
    String COLUMN_TITLE = "title";
    String COLUMN_AMOUNT="amount";
    String ACCOUNT_TABLE_CREATE=String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," + "%s TEXT UNIQUE NOT NULL,%s REAL NOT NULL)",
            ACCOUNT_TABLE, COLUMN_ID, COLUMN_TITLE, COLUMN_AMOUNT);
    String[] ACCOUNT_COLUMNS= new String[]{COLUMN_ID,COLUMN_TITLE,COLUMN_AMOUNT};
}
