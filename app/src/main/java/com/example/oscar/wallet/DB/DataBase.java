package com.example.oscar.wallet.DB;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.oscar.wallet.DB.DAOImpl.AccountDao;
import com.example.oscar.wallet.DB.DAOImpl.CategoryDao;
import com.example.oscar.wallet.DB.Schemas.IAccountSchema;
import com.example.oscar.wallet.DB.Schemas.ICategorySchema;
import com.example.oscar.wallet.Models.Category;

/**
 * Created by oscar on 31/12/2017.
 */

public class DataBase {
    private static final String TAG= "MyDateBase";
    private static final  String DATA_BASE_NAME= "Wallet.db";
    private static final  int DATA_BASE_VERSION= 1;
    private DatabaseHelper dbHelper;
    private final Context context;
    public static AccountDao accountDao;
    public  static CategoryDao categoryDao;

    public DataBase(Context context) {
        this.context = context;
    }

    public DataBase open() throws SQLException{
        dbHelper= new DatabaseHelper(context);
       SQLiteDatabase mDb = dbHelper.getWritableDatabase();
        accountDao= new AccountDao(mDb);
        categoryDao= new CategoryDao(mDb);
        return this;
    }

    public void close(){
        dbHelper.close();
    }


    private static  class DatabaseHelper extends SQLiteOpenHelper{

        public DatabaseHelper(Context context) {
            super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(IAccountSchema.ACCOUNT_TABLE_CREATE);
            sqLiteDatabase.execSQL(ICategorySchema.CATEGORY_TABLE_CREATE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            Log.w(TAG,"Upgrading data base from version"+i+"to"+i1+"wich destroy old version");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+IAccountSchema.ACCOUNT_TABLE);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ICategorySchema.CATEGORY_TABLE);

            onCreate(sqLiteDatabase);
        }
    }
}
