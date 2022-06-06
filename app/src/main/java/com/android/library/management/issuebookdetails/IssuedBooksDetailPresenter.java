package com.android.library.management.issuebookdetails;


public class IssuedBooksDetailPresenter implements IssuedBooksDetailInterface.Presenter {
    IssuedBooksDetailInterface.View view;
    IssuedBooksDetailInterface.Model model;

    public IssuedBooksDetailPresenter(IssuedBooksDetailInterface.View view, IssuedBooksDetailInterface.Model model) {
        this.model = model;
        this.view = view;
    }

    // Function that initializes variables
    public void initPresenter() {
        view.initAllViews();
    }

    // Fetch data using the following function
    public void fetchData(String id) {
        view.BookDetailSet(model.fetchBookDetails(id));
    }
}
