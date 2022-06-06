package com.android.library.management.returnbook;

public interface ReturnBookInterface {
    public interface View {
        void initAllViews();

        void setListeners();

        void showPicker();

        void resetEditTexts();

        void redirectBackToDetails(String issueDate, String sID);
    }

    public interface Presenter {
    }

    public interface Model {
        String getIssueData(String sID);

        Boolean getIsAlreadyExist(String sID);
    }
}
