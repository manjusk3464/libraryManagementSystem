package com.android.library.management.bookslist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.library.management.R;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private ArrayList<String> bookNames;
    onItemClick mListener;

    public interface onItemClick {
        void onItemClicked(int position);
    }

    public void setOnItemClickListener(onItemClick listener) {
        this.mListener = listener;
    }


    public BooksAdapter(Context context, ArrayList<String> List) {
        bookNames = List;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView BookName, Author;
        ImageView BookImage;

        public ViewHolder(@NonNull View itemView, final onItemClick listener) {
            super(itemView);

            BookName = itemView.findViewById(R.id.IdBookName);
            Author = itemView.findViewById(R.id.IdAuthorName);
            BookImage = itemView.findViewById(R.id.IvBook);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClicked(position);
                        }
                    }
                }
            });
        }
    }


    @NonNull
    @Override
    public BooksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.activity_books_list_interface, viewGroup, false);
        return new ViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(bookNames.get(i));
        viewHolder.BookName.setText(bookNames.get(i));
    }

    // Returns count of books
    @Override
    public int getItemCount() {
        return bookNames.size();
    }
}
