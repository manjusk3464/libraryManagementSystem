package com.android.library.management.bookslist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.library.management.R;
import com.android.library.management.utils.StatsShow;

import java.util.ArrayList;

public class BooksList extends AppCompatActivity implements BookListInterface.View {
    RecyclerView recyclerView;
    BooksAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    BookListPresenter presenter;
    ArrayList<String> booksNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        presenter = new BookListPresenter(this, new BookListModel(getApplicationContext()));
        presenter.initPresenter();
    }

    @Override
    public void initAllViews() {
        recyclerView = findViewById(R.id.RvList);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        booksNames = new ArrayList<>();
        myAdapter = new BooksAdapter(this.getApplicationContext(), booksNames);
        recyclerView.setAdapter(myAdapter);
    }

    // Listener function
    @Override
    public void setListeners() {
        myAdapter.setOnItemClickListener(new BooksAdapter.onItemClick() {
            @Override
            public void onItemClicked(int position) {
                Intent intent = new Intent(getApplicationContext(),
                        StatsShow.class);
                String name = "";
                name = booksNames.get(position).trim();
                Toast.makeText(BooksList.this, name, Toast.LENGTH_SHORT).show();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }

    // refreshing the adapter data
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void setData(ArrayList<String> names) {
        booksNames.clear();
        booksNames.addAll(names);
        myAdapter.notifyDataSetChanged();
    }
}
