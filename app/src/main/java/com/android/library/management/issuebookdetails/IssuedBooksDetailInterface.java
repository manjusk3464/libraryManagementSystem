package com.android.library.management.issuebookdetails;

// Interface to implement MVP design pattern
public interface IssuedBooksDetailInterface {
    public interface View {
        void initAllViews();
        void BookDetailSet(String bookDetails);
    }

    public interface Model {
        String fetchBookDetails(String id);
    }

    public interface Presenter {
    }
}
