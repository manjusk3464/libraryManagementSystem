package com.android.library.management.Issuebooklist;

import java.util.ArrayList;

public interface IssuedBooksListInterface {
    public interface View {
        void initAllViews();

        void setListeners();

        void setBooksList(ArrayList<String> data);
    }

    public interface Presenter {
    }

    public interface Model {
        ArrayList<String> getData();
    }
}
