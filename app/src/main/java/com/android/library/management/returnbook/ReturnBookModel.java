package com.android.library.management.returnbook;

import android.content.Context;
import android.util.Pair;

import com.android.library.management.issuebook.DbIssueBook;

public class ReturnBookModel implements ReturnBookInterface.Model {
    Context context;
    Pair<String, Boolean> pair = new Pair<String, Boolean>("", false);

    public ReturnBookModel(Context applicationContext) {
        this.context = applicationContext;
    }

    // Fetch issue date from db
    @Override
    public String getIssueData(String sID) {
        DbIssueBook dbIssueBook = new DbIssueBook(context);
        dbIssueBook.open();
        String issueDate = dbIssueBook.getIssueDate(sID);
        dbIssueBook.close();
        return issueDate;
    }

    // Checks if book already exists
    public Boolean getIsAlreadyExist(String sID) {
        DbIssueBook dbIssueBook = new DbIssueBook(context);
        dbIssueBook.open();
        boolean exist = dbIssueBook.AlreadyExist(sID);
        dbIssueBook.close();
        return exist;
    }
}
