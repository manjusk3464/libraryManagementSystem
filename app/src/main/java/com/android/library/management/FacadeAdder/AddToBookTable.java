package com.android.library.management.FacadeAdder;

import android.content.Context;
import android.util.Log;

import com.android.library.management.helper.dbHelper;

// Implementation of facade design pattern
public class AddToBookTable implements addToTable {
    @Override
    public void add(Context context,String Sname,String Spublisher,String Sedition,String Spages,String Sprice) {
        Log.i("reached","add to book");
        dbHelper db = new dbHelper(context);
        db.open();
        db.createBookEntry(Sname, Spublisher, Sedition, Spages, Sprice);
        db.close();
    }
}
