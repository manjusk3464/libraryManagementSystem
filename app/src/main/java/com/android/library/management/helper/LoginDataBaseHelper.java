package com.android.library.management.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginDataBaseHelper extends SQLiteOpenHelper {

    private static LoginDataBaseHelper sInstance;

    public static LoginDataBaseHelper getInstance(Context context) {
        //singleton pattern is being implemented
        if (sInstance == null) {
            sInstance = new LoginDataBaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    // Create table and add email and password
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(email text primary key, password text)");
    }

    // Drop table if already existing
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "user");
        onCreate(db);

    }

    // Function to create super admin
    public Boolean createsuperadmin() {
        return true;
    }

    // Insert email and password to the db
    public Boolean insert(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("email", email);
        cv.put("password", password);
        long ins = db.insert("user", null, cv);


        if (ins == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Check if email already exists
    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from user where email=?", new String[]{email});
        if (c.getCount() > 0) {
            return false;
        } else {
            return true;
        }

    }

    // Validating user login
    public Boolean loginCheck(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from user where email=? and password=?", new String[]{email, password});

        if (c.getCount() > 0) return true;
        else return false;
    }

    public LoginDataBaseHelper(Context context) {
        super(context, "login.db", null, 1);
    }

}
