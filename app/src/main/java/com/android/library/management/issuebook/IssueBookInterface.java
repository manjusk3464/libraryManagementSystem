package com.android.library.management.issuebook;

public interface IssueBookInterface {
    public interface View {
        void initAllViews();

        void setListeners();

        void showDataPickerDialog();
    }

    public interface Presenter {
    }

    public interface Model {
    }
}
