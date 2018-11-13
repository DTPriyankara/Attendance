package com.example.dushyantha.attendanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.jar.Attributes;

public class DatabaseHelperLogin extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Attendance_db";
    public static final String TABLE_NAME = "lecture";
    public static final String COL_1= "lec_id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "password";

    public DatabaseHelperLogin(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL("create table " + TABLE_NAME +"(lec_id TEXT primary key, name TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {
        db1.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db1);
    }

    public boolean insert(String lec_id, String name, String password){
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put(COL_1, lec_id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, password);
        long ins = db1.insert(TABLE_NAME,null,contentValues);
        if (ins == 1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(){
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor res = db1.rawQuery("select * from "+ TABLE_NAME, null);
        return res;

    }

    public  boolean checkId(String lec_id){
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor cursor = db1.rawQuery("select * from user where lec_id=?", new String[]{lec_id});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //check the lec_id and password

    public boolean id_pass(String lec_id, String password){
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor cursor = db1.rawQuery("select * from "+TABLE_NAME+" where lec_id=? and password=?", new String[] {lec_id,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
