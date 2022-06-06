package com.android.library.management.issuebookdetails;

import android.content.Context;
import android.util.Log;

import com.android.library.management.issuebook.DbIssueBook;
// Model class
public class IssuedBooksDetailModel implements IssuedBooksDetailInterface.Model {
    Context context;

    public IssuedBooksDetailModel(Context applicationContext) {
        this.context = applicationContext;
    }

    // Query to fetch book details
    @Override
    public String fetchBookDetails(String id) {
        DbIssueBook dbIssueBook = new DbIssueBook(context);
        dbIssueBook.open();
        String data = dbIssueBook.getIssueBook(id);
        dbIssueBook.close();

        Log.i("issuedData", "data model" + data);

        return data;
    }
}
