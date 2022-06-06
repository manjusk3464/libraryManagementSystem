package com.android.library.management.bookslist;

import android.content.Context;

import com.android.library.management.helper.dbHelper;

import java.util.ArrayList;

public class BookListModel implements BookListInterface.Model {
    Context context;
    dbHelper db;
    ArrayList<String> BooksName;

    public BookListModel(Context context) {
        this.context = context;
    }

    // This function is to initialize the data base.
    @Override
    public ArrayList<String> getData() {
        db = new dbHelper(context);
        db.open();
        BooksName = db.getName();
        db.close();
        return BooksName;
    }
}
