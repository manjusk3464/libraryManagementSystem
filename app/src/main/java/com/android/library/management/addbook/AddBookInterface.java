package com.android.library.management.addbook;

import java.util.ArrayList;
//This is the interface that will be implemented
public interface AddBookInterface {
    public interface View {
        void initAllViews();

        void setListeners();

        void resetTexts();
    }
    public interface Presenter {
    }

    public interface Model {
        void checkFieldsNAddBook(String Sname, String Sedition, String Spages, String Sprice, String Spublisher);

    }
}
