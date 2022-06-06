package com.android.library.management.Issuebooklist;

import android.content.Context;

import com.android.library.management.issuebook.DbIssueBook;

import java.util.ArrayList;

public class IssuedBooksListModel implements IssuedBooksListInterface.Model {
    Context context;
    ArrayList<String> booksList = new ArrayList<>();

    public IssuedBooksListModel(Context applicationContext) {
        this.context = applicationContext;
    }

    // Get issued book list
    @Override
    public ArrayList<String> getData() {
        DbIssueBook dbIssueBook = new DbIssueBook(context);
        dbIssueBook.open();
        booksList = dbIssueBook.getName();
        dbIssueBook.close();
        return booksList;
    }
}
