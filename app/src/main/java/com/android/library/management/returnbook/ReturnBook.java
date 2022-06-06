package com.android.library.management.returnbook;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.android.library.management.detailReturnBook.DetailReturnBk;
import com.android.library.management.R;

import java.util.Calendar;

public class ReturnBook extends AppCompatActivity implements ReturnBookInterface.View {
    private EditText BookName, ID, author, edition, StName, RegNo;
    private TextView returnDate;
    private Button BtnReturn;
    private String Rdate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    ReturnBookPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book);
        presenter = new ReturnBookPresenter(this, new ReturnBookModel(getApplicationContext()), getApplicationContext());
        presenter.initPresenter();
    }

    @Override
    public void initAllViews() {
        BookName = findViewById(R.id.BookName);
        ID = findViewById(R.id.BookID);
        author = findViewById(R.id.Author);
        edition = findViewById(R.id.Edition);
        returnDate = findViewById(R.id.ReturnDate);
        StName = findViewById(R.id.StName);
        RegNo = findViewById(R.id.StReg);
        BtnReturn = findViewById(R.id.BtnReturn);
    }

    @Override
    public void setListeners() {
        returnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onReturnClicked();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Rdate = month + "/" + dayOfMonth + "/" + year;
                returnDate.setText(Rdate);
            }
        };

        BtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBtnReturnClicked(ID, BookName, author, edition, StName, RegNo, Rdate);
            }
        });
    }

    @Override
    public void showPicker() {
        // Function to display picker
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(ReturnBook.this,
                android.R.style.Theme_DeviceDefault_Dialog_MinWidth, onDateSetListener,
                year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void resetEditTexts() {
        ID.setText("");
        author.setText("");
        edition.setText("");
        BookName.setText("");
        returnDate.setText("");
        StName.setText("");
        RegNo.setText("");
    }

    // Funtion to redirect
    @Override
    public void redirectBackToDetails(String issueDate, String sID) {
        Intent intent = new Intent(getApplicationContext(),
                DetailReturnBk.class);
        intent.putExtra("issueDate", issueDate);
        intent.putExtra("returnDate", Rdate);
        intent.putExtra("Id", sID);
        startActivity(intent);
    }
}
