package com.android.library.management.detailReturnBook;

import android.content.Context;
import android.widget.Toast;
// This is a presenter class
public class DetailReturnBkPresenter {
    DetailReturnBkInterface.View view;
    DetailReturnBkInterface.Model model;
    Context context;

    public DetailReturnBkPresenter(DetailReturnBkInterface.View view, DetailReturnBkInterface.Model model, Context applicationContext) {
        this.model = model;
        this.view = view;
        this.context = applicationContext;
    }

    public void initAllViews() {
        view.initAllViews();
        view.setListeners();
    }

    // Upon clicking on submit handles the book status if it is submitted or not returned
    public void submitButtonClicked(String sID) {
        Long deleted = model.deleteaBook(sID);

        if (deleted != -1) {
            view.resetAllEditTexts();
            Toast.makeText(context, "Submitted Successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Book not returned!", Toast.LENGTH_SHORT).show();
        }
    }
}
