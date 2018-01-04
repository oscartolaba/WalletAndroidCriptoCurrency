package com.example.oscar.wallet.DB.DAOImpl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.oscar.wallet.DB.DAO.ICategoryDao;
import com.example.oscar.wallet.DB.Providers.DbContentProvider;
import com.example.oscar.wallet.DB.Schemas.ICategorySchema;
import com.example.oscar.wallet.Models.Account;
import com.example.oscar.wallet.Models.Category;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by oscar on 31/12/2017.
 */

public class CategoryDao extends DbContentProvider implements ICategoryDao,ICategorySchema {
    private Cursor cursor;
    private ContentValues initialValues;

    public CategoryDao(SQLiteDatabase mDb) {
        super(mDb);
    }

    @Override
    protected Category cursorToEntity(Cursor cursor) {
        Category category= new Category();
        int idIndex,descriptionIndex,typeCategoryIndex;
        if(cursor!=null){
            if(cursor.getColumnIndex(COLUMN_ID)!=-1){
                idIndex= cursor.getColumnIndexOrThrow(COLUMN_ID);
                category.setId(cursor.getInt(idIndex));
            }
            if(cursor.getColumnIndex(COLUMN_DESCRIPTION)!=-1){
                descriptionIndex= cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION);
                category.setDescripcion(cursor.getString(descriptionIndex));
            }
            if(cursor.getColumnIndex(COLUMN_TYPE_CATEGORY)!=-1){
                typeCategoryIndex= cursor.getColumnIndexOrThrow(COLUMN_TYPE_CATEGORY);
                category.setTypeCategory(cursor.getString(typeCategoryIndex));
            }
        }
        return category;
    }

    @Override
    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories= new ArrayList<>();
        cursor= super.query(CATEGORY_TABLE,CATEGORY_COLUMNS,null,null,COLUMN_DESCRIPTION);
        if(cursor!=null){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Category category= cursorToEntity(cursor);
                categories.add(category);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return categories;    }

    @Override
    public boolean addCategory(Category category) {
        setContentValue(category);
        try{
            return super.insert(CATEGORY_TABLE,getContentValue())>0;
        }catch (SQLiteConstraintException ex){
            Log.w("DataBase",ex.getMessage());
            return false;
        }
    }


    private void setContentValue(Category category){
        initialValues = new ContentValues();
        initialValues.put(COLUMN_DESCRIPTION,category.getDescripcion());
        initialValues.put(COLUMN_TYPE_CATEGORY, category.getTypeCategory());
    }

    private ContentValues getContentValue(){
        return initialValues;
    }

    @Override
    public boolean updateCategory(Category category) {
        return false;
    }

    @Override
    public boolean deleteCategory(int id) {
        return false;
    }
}
