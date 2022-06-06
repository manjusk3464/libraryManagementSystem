package com.android.library.management.returnbook;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

public class ReturnBookPresenter implements ReturnBookInterface.Presenter {
    ReturnBookInterface.View view;
    ReturnBookInterface.Model model;
    Context context;

    public ReturnBookPresenter(ReturnBookInterface.View view, ReturnBookInterface.Model model, Context applicationContext) {
        this.model = model;
        this.view = view;
        this.context = applicationContext;
    }

    public void initPresenter() {
        view.initAllViews();
        view.setListeners();
    }

    public void onReturnClicked() {
        view.showPicker();
    }

    // Trims variable and store
    public void onBtnReturnClicked(EditText ID, EditText bookName, EditText author, EditText edition, EditText stName, EditText regNo, String rdate) {
        String sID = ID.getText().toString().trim();
        String sName = bookName.getText().toString().trim();
        String sAuthor = author.getText().toString().trim();
        String sEdition = edition.getText().toString().trim();
        String sStName = stName.getText().toString().trim();
        String sRegNo = regNo.getText().toString().trim();

        // Check if field is empty and then show a toast
        if (sID.isEmpty() || sAuthor.isEmpty() || sEdition.isEmpty() || sName.isEmpty()
                || sStName.isEmpty() || sRegNo.isEmpty()) {
            Toast.makeText(context, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
        } else {
            String issueDate = model.getIssueData(sID);
            Boolean exist = model.getIsAlreadyExist(sID);
            if (exist) {
                view.resetEditTexts();
                view.redirectBackToDetails(issueDate, sID);
            } else {
                Toast.makeText(context, "This book does not exist in Issued Books!",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }
}
