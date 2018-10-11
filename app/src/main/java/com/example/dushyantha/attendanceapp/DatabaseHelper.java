package com.example.dushyantha.attendanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Attendance_db";
    public static final String TABLE_NAME = "student";
    public static final String COL_1 = "reg_no";
    public static final String COL_2 = "name";
    public static final String COL_3 = "level_of_study";
    public static final String COL_4 = "password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(reg_no TEXT PRIMARY KEY, name TEXT, level_of_study TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String reg_no, String name, String level_of_study, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, reg_no);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, level_of_study);
        contentValues.put(COL_4, password);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }
}
