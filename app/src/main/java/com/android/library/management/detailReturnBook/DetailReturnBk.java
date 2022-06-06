package com.android.library.management.detailReturnBook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.library.management.R;
import com.android.library.management.utils.ToastUtil;

public class DetailReturnBk extends AppCompatActivity implements DetailReturnBkInterface.View {
    TextView issueDate, ReturnDate;
    EditText Fine;
    Button submit;
    DetailReturnBkPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_return_bk);
        presenter = new DetailReturnBkPresenter(this, new DetailReturnBkModel(getApplicationContext()), getApplicationContext());
        presenter.initAllViews();
        ToastUtil.getInstance("sting", this);
    }

    @Override
    public void initAllViews() {
        issueDate = findViewById(R.id.Tvissuedate);
        ReturnDate = findViewById(R.id.TvReturndate);
        Fine = findViewById(R.id.TvFine);
        submit = findViewById(R.id.btn_login);

        Intent intent = getIntent();
        String issuedate = intent.getStringExtra("issueDate");
        String returndate = intent.getStringExtra("returnDate");

        issueDate.setText(issuedate);
        ReturnDate.setText(returndate);
        String fine = Fine.getText().toString().trim();
        if (fine.equals(""))
            fine = "0";
    }

    @Override
    public void setListeners() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String sID = intent.getStringExtra("Id");
                presenter.submitButtonClicked(sID);
            }
        });
    }

    @Override
    public void resetAllEditTexts() {
        issueDate.setText("");
        ReturnDate.setText("");
        Fine.setText("");
    }
}
