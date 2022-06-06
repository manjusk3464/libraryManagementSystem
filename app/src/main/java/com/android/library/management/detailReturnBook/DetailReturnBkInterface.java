package com.android.library.management.detailReturnBook;

// This in an interface that initializes the listeners
public interface DetailReturnBkInterface {
    public interface View {
        void initAllViews();

        void setListeners();

        void resetAllEditTexts();
    }

    public interface Presenter {
    }

    // A function declaration that will be overridden to delete a book
    public interface Model {
        Long deleteaBook(String sID);
    }
}
