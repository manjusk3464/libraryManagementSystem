package com.android.library.management.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.android.library.management.R;
import com.android.library.management.addbook.AddBook;
import com.android.library.management.bookslist.BooksList;
import com.android.library.management.issuebook.IssueBookActivity;
import com.android.library.management.returnbook.ReturnBook;

public class LibraryMenu extends AppCompatActivity {

    ImageView issueaBook, addaBook, returnaBook, AddNewAccount, Statistics;
    TextView issueBookTv, AddBookTv, ReturnBookTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_menu);

        addaBook = findViewById(R.id.IvnewBook);
        issueaBook = findViewById(R.id.IvIssueBook);
        returnaBook = findViewById(R.id.IvReturnBook);
        AddNewAccount = findViewById(R.id.IvAddAccount);
        Statistics = findViewById(R.id.IvStats);
        AddBookTv = findViewById(R.id.TVNewBook);
        issueBookTv = findViewById(R.id.TVIssueBook);
        ReturnBookTv = findViewById(R.id.TVReturnBook);
        Intent intent2 = getIntent();
        final String choice = intent2.getStringExtra("userChoice");
        if (choice.equalsIgnoreCase("Student")) {
            addaBook.setVisibility(View.INVISIBLE);
            AddBookTv.setVisibility(View.INVISIBLE);
            issueaBook.setVisibility(View.INVISIBLE);
            returnaBook.setVisibility(View.INVISIBLE);
            issueBookTv.setVisibility(View.INVISIBLE);
            ReturnBookTv.setVisibility(View.INVISIBLE);
        }
        AddNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        register.class);
                startActivity(intent);
            }
        });


        addaBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),
                        AddBook.class);
                startActivity(intent);

            }
        });
        Statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice.equalsIgnoreCase("Student") || choice.equalsIgnoreCase("Faculty")) {
                    Intent intent = new Intent(getApplicationContext(),
                            BooksList.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(),
                            Books_stats_menu.class);
                    startActivity(intent);
                }

            }
        });
        issueaBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        IssueBookActivity.class);
                startActivity(intent);

            }
        });
        returnaBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        ReturnBook.class);
                startActivity(intent);
            }
        });

    }
}
