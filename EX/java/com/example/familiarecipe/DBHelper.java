package com.example.familiarecipe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FamiliaRecipes";
    public static final String TABLE_USER_INFO =  "user_info";
    public static final String TABLE_ARTICLES =  "articles";
    public static final String TABLE_MY_ARTICLES =  "my_articles";

    public static final String KEY_ARTICLES_ID = "_id";
    public static final String KEY_ARTICLE_NAME = "article_name";
    public static final String KEY_ARTICLE_INFO = "article_info";

    public static final String KEY_MY_ARTICLE_ID = "_id";
    public static final String KEY_MY_ID_OF_SAVED_ARTICLE = "id of saved article";


    public static final String KEY_USER_ID = "_id";
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_USER_EMAIL = "user_email";
    public static final String KEY_USER_PASSWORD = "user_password";
    public static final String KEY_USER_IMAGE=  "user_image";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //String sql = "create table School_Lessions (_id integer primary key, Les_Name text)";
        //db.execSQL(sql);
        /*db.execSQL("create table " + TABLE_LESSIONS + "(" + KEY_ID
                + " integer primary key," + KEY_LESSION_NAME + " text" + ")");*/

        db.execSQL("create table " + TABLE_USER_INFO + "(" + KEY_USER_ID
                + " integer primary key," + KEY_USER_NAME + " text," + KEY_USER_EMAIL + " text," + KEY_USER_PASSWORD + " text," + KEY_USER_IMAGE + " blob" + ")");
        db.execSQL("create table " + TABLE_ARTICLES + "(" + KEY_ARTICLES_ID
                + " integer primary key," + KEY_ARTICLE_NAME + " text," + KEY_ARTICLE_INFO + " text" + ")");
        db.execSQL("create table " + TABLE_MY_ARTICLES + "(" + KEY_MY_ARTICLE_ID
                + " integer primary key," + KEY_MY_ID_OF_SAVED_ARTICLE + " integer" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
