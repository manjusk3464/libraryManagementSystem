package com.android.library.management.bookslist;

import java.util.ArrayList;

public interface BookListInterface {
    public interface View {
        void initAllViews();

        void setListeners();

        void setData(ArrayList<String> names);
    }

    public interface Presenter {
    }

    public interface Model {
        ArrayList<String> getData();
    }
}
