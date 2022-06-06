package com.android.library.management.bookslist;

public class BookListPresenter implements BookListInterface.Presenter {
    BookListInterface.View view;
    BookListInterface.Model model;

    public BookListPresenter(BookListInterface.View view, BookListInterface.Model model) {
        this.view = view;
        this.model = model;
    }

    // This is function initializes the event listeners
    public void initPresenter() {
        view.initAllViews();
        view.setListeners();
        view.setData(model.getData());
    }
}
