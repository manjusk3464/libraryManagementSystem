package com.android.library.management.Issuebooklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.library.management.issuebookdetails.IssuedBooksDataDisplay;
import com.android.library.management.R;
import com.android.library.management.bookslist.BooksAdapter;

import java.util.ArrayList;

public class IssuedBooksListActivity extends AppCompatActivity implements IssuedBooksListInterface.View {

    private RecyclerView recyclerView;
    private BooksAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    IssuedBookListPresenter presenter;
    ArrayList<String> booksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issued_books_list);
        presenter = new IssuedBookListPresenter(this, new IssuedBooksListModel(getApplicationContext()));
        presenter.initPresenter();
    }

    @Override
    public void initAllViews() {
        recyclerView = findViewById(R.id.RvIssuedBooks);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        booksList = new ArrayList<>();
        myAdapter = new BooksAdapter(getApplicationContext(), booksList);
        recyclerView.setAdapter(myAdapter);
        Log.i("issued", "init");
    }

    @Override
    public void setListeners() {
        myAdapter.setOnItemClickListener(new BooksAdapter.onItemClick() {
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(getApplicationContext(), IssuedBooksDataDisplay.class);
                String Id = "";
                String Id1 = "";
                Id = booksList.get(position).trim();
                String[] words = Id.split("\\.");
                intent.putExtra("DataId", words[0]);
                startActivity(intent);
            }
        });
    }


    @Override
    public void setBooksList(ArrayList<String> data) {
        Log.i("issued", "init " + data);
        booksList.clear();
        booksList.addAll(data);
        myAdapter.notifyDataSetChanged();
    }
}
