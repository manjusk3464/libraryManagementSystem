package com.android.library.management.detailReturnBook;

import android.content.Context;

import com.android.library.management.issuebook.DbIssueBook;

public class DetailReturnBkModel implements DetailReturnBkInterface.Model {
    Context context;

    public DetailReturnBkModel(Context applicationContext) {
        this.context = applicationContext;
    }

    // Funcion that handles the data base
    @Override
    public Long deleteaBook(String sID) {
        DbIssueBook dbIssueBook = new DbIssueBook(context);
        dbIssueBook.open();
        long deleted = dbIssueBook.deleteBook(sID);
        dbIssueBook.close();
        return deleted;
    }
}
