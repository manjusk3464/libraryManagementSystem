package com.android.library.management.addbook;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;
// This is the presenter which hides the business logic
public class AddBookPresenter implements AddBookInterface.Presenter {
    AddBookInterface.View view;
    AddBookInterface.Model model;
    Context context;

    public AddBookPresenter(AddBookInterface.View view, AddBookInterface.Model model, Context context) {
        this.view = view;
        this.model = model;
        this.context = context;
    }

    public void initPresenter() {
        view.initAllViews();
        view.setListeners();
    }

    public void onAddBookClicked(EditText name, EditText edition, EditText pages, EditText publisher, EditText price) {
        String Sname = name.getText().toString();
        String Sedition = edition.getText().toString().trim();
        String Spages = pages.getText().toString().trim();
        String Spublisher = publisher.getText().toString();
        String Sprice = price.getText().toString().trim();
        // The following code checks if Name, Edition, Pages, Price and Publisher is empty and shows a toast.
        if (Sname.isEmpty() || Sedition.isEmpty() ||
                Spages.isEmpty() || Sprice.isEmpty() ||
                Spublisher.isEmpty()) {
            Toast.makeText(context, "Fill all the fields to add a book!",
                    Toast.LENGTH_SHORT).show();
        } else {
            model.checkFieldsNAddBook(Sname, Sedition, Spages, Sprice, Spublisher);
            view.resetTexts();
        }
    }
}
