package com.android.library.management.issuebook;

public class IssueBookPresenter implements IssueBookInterface.Presenter {
    IssueBookInterface.View view;
    IssueBookInterface.Model model;

    public IssueBookPresenter(IssueBookInterface.View view, IssueBookInterface.Model model) {
        this.view = view;
        this.model = model;
    }

    public void initPresenter() {
        view.initAllViews();
        view.setListeners();
    }

    public void onIssueDateClicked() {
        view.showDataPickerDialog();
    }


}
