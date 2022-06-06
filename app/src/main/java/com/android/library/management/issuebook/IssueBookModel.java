package com.android.library.management.issuebook;

import android.content.Context;

public class IssueBookModel implements IssueBookInterface.Model{
    Context context;
    public IssueBookModel(Context applicationContext) {
        this.context = applicationContext;
    }
}
