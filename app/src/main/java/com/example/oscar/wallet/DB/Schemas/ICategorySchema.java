package com.example.oscar.wallet.DB.Schemas;

/**
 * Created by oscar on 31/12/2017.
 */

public interface ICategorySchema {
    String CATEGORY_TABLE="Category";
    String COLUMN_ID="id";
    String COLUMN_DESCRIPTION = "description";
    String COLUMN_TYPE_CATEGORY="type_category";
    String CATEGORY_TABLE_CREATE=String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," + "%s TEXT UNIQUE NOT NULL,%s TEXT NOT NULL)",
            CATEGORY_TABLE, COLUMN_ID, COLUMN_DESCRIPTION, COLUMN_TYPE_CATEGORY);
    String[] CATEGORY_COLUMNS= new String[]{COLUMN_ID,COLUMN_DESCRIPTION,COLUMN_TYPE_CATEGORY};
}
