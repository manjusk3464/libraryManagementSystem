package com.android.library.management.addbook;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.library.management.FacadeAdder.FacadeBookAdder;
import com.android.library.management.R;
import com.android.library.management.helper.dbHelper;

import java.util.ArrayList;
import java.util.Locale;
// MVP design pattern is being implemented
public class AddBook extends AppCompatActivity implements AddBookInterface.View {
    EditText name, edition, publisher, pages, price;
    Button addBook;
    AddBookPresenter presenter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        context = this;
        presenter = new AddBookPresenter(this, new AddBookModel(getApplicationContext()), getApplicationContext());
        presenter.initPresenter();
    }

    @Override
    public void initAllViews() {
        name = findViewById(R.id.EtBookName);
        edition = findViewById(R.id.EtBookEdition);
        pages = findViewById(R.id.EtbookPages);
        publisher = findViewById(R.id.EtbookPublisher);
        price = findViewById(R.id.EtbookPrice);
        addBook = findViewById(R.id.BtnAddBook);
    }

    @Override
    public void setListeners() {
        final String Sname = name.getText().toString();
        final String Sedition = edition.getText().toString().trim();
        final String Spages = pages.getText().toString().trim();
        final String Spublisher = publisher.getText().toString();
        final String Sprice = price.getText().toString().trim();
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onAddBookClicked(name,edition,pages,publisher,price);
            }
        });
    }

    @Override
    public void resetTexts() {
        name.setText("");
        edition.setText("");
        pages.setText("");
        price.setText("");
        publisher.setText("");
    }

}
