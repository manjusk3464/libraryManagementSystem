package com.android.library.management.Issuebooklist;

import android.util.Log;

public class IssuedBookListPresenter {
    IssuedBooksListInterface.View view;
    IssuedBooksListInterface.Model model;

    public IssuedBookListPresenter(IssuedBooksListInterface.View view, IssuedBooksListInterface.Model model) {
        this.view = view;
        this.model = model;
    }

    public void initPresenter() {
        Log.i("issued","presenter");

        view.initAllViews();
        view.setListeners();
        view.setBooksList(model.getData());

    }
}
