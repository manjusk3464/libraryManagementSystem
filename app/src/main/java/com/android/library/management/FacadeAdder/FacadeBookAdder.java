package com.android.library.management.FacadeAdder;

import android.content.Context;
import android.widget.Toast;

// Facade design pattern
public class FacadeBookAdder {
    private addToTable book;
    private addToTable magazine;

    public FacadeBookAdder() {
        book = new AddToBookTable();
        magazine = new AddToMagazineTable();
    }

    // This function checks if it is a book or magazine and then adds it to database
    public void addBook(Context context, String Sname, String Spublisher, String Sedition, String Spages, String Sprice) {
        book.add(context, Sname, Spublisher, Sedition, Spages, Sprice);
        Toast.makeText(context, "Saved Successfully!", Toast.LENGTH_SHORT).show();
    }
    // This function checks if it is a book or magazine and then adds it to database
    public void addMagazine(Context context, String Sname, String Spublisher, String Sedition, String Spages, String Sprice) {
        magazine.add(context, Sname, Spublisher, Sedition, Spages, Sprice);
        Toast.makeText(context, "Saved Successfully!", Toast.LENGTH_SHORT).show();
    }
}
