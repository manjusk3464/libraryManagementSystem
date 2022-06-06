package com.android.library.management.addbook;

import android.content.Context;
import android.widget.Toast;

import com.android.library.management.FacadeAdder.FacadeBookAdder;

import java.util.ArrayList;
import java.util.Locale;
// This is the model which has the logic
public class AddBookModel implements AddBookInterface.Model {

    Context context;

    public AddBookModel(Context applicationContext) {
        this.context = applicationContext;
    }

    // Function to check fields and add book
    @Override
    public void checkFieldsNAddBook(String Sname, String Sedition, String Spages, String Sprice, String Spublisher) {
        String var = Sedition.toLowerCase(Locale.ROOT);
        FacadeBookAdder adder = new FacadeBookAdder();
        if (var.contains("book"))
            adder.addBook(context, Sname, Spublisher, Sedition, Spages, Sprice);
        else if (var.contains("magazine"))
            adder.addMagazine(context, Sname, Spublisher, Sedition, Spages, Sprice);
        else
            Toast.makeText(context, "Failed!", Toast.LENGTH_SHORT).show();
    }
}

