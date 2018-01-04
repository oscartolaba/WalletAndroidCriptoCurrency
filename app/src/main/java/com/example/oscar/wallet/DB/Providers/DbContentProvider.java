package com.example.oscar.wallet.DB.Providers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by oscar on 31/12/2017.
 */

public abstract class DbContentProvider {
    public SQLiteDatabase mDb;

    public DbContentProvider(SQLiteDatabase mDb) {
        this.mDb = mDb;
    }

    public int delete(String tableName, String selection, String[] selectionArgs ){
        return mDb.delete(tableName,selection,selectionArgs);
    }
    public long insert(String tableName, ContentValues values){
        return mDb.insert(tableName,null,values);
    }

    public int update(String tableName,ContentValues values, String selection,String[] selectionArgs ){
        return mDb.update(tableName,values,selection,selectionArgs);
    }

    public Cursor query(String tableName,String[] columns, String selection,String[] selectionArgs,String sortOrder){
        final Cursor cursor= mDb.query(tableName,columns,selection,selectionArgs,null,null,sortOrder);
       return cursor;
    }
    protected abstract <T> T cursorToEntity(Cursor cursor);



}
