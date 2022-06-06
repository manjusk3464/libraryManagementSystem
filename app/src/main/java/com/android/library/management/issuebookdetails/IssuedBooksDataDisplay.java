package com.android.library.management.issuebookdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.library.management.R;

public class IssuedBooksDataDisplay extends AppCompatActivity implements IssuedBooksDetailInterface.View {
    TextView name, BookId, author, issueDate, Stname, StReg, dueDate;

    IssuedBooksDetailPresenter presenter;
    String Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issued_books_data_display);
        presenter = new IssuedBooksDetailPresenter(this, new IssuedBooksDetailModel(getApplicationContext()));
        presenter.initPresenter();
    }

    // Initialize variables
    @Override
    public void initAllViews() {
        name = findViewById(R.id.BookNameD);
        BookId = findViewById(R.id.BookIdD);
        author = findViewById(R.id.BookAuthorD);
        issueDate = findViewById(R.id.BookIssueDateD);
        Stname = findViewById(R.id.BookStudentNameD);
        StReg = findViewById(R.id.RegNoD);
        dueDate = findViewById(R.id.BookDueDateD);

        Intent intent = getIntent();
        Id = intent.getStringExtra("DataId");
        presenter.fetchData(Id);
        Log.i("issuedData", "data" + Id);
    }

    // Function to set details of book
    @Override
    public void BookDetailSet(String bookDetails) {
        Log.i("issuedData", "data bookDetails" + bookDetails);
        if (bookDetails != null) {
            String[] arrOfData = bookDetails.split("#!");
            String length = "length" + Id;
            if (arrOfData.length == 8) {
                name.setText("NAME:    " + arrOfData[1]);
                BookId.setText("ID:    " + arrOfData[0]);
                author.setText("AUTHOR:    " + arrOfData[2]);
                issueDate.setText("ISSUE DATE:    " + arrOfData[6]);
                StReg.setText("STUDENT REG NUMBER:    " + arrOfData[5]);
                Stname.setText("STUDENT NAME:    " + arrOfData[4]);
                dueDate.setText("DUE DATE:    " + arrOfData[7]);
            } else {
                name.setText("NO data to Display!1");
            }
        } else {
            name.setText("NO data to Display!2");
        }
    }
}
