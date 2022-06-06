package com.android.library.management.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.library.management.R;

public class MainActivity extends AppCompatActivity {
    Button StudentBtn, superAdminBtn, adminBtn;
    TextView registerText;

    // Functions that checks for students choice
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentBtn = findViewById(R.id.studentBtn);
        superAdminBtn = findViewById(R.id.superAdminBtn);
        adminBtn = findViewById(R.id.adminBtn);
        registerText = findViewById(R.id.RegisterAccount);

        StudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice;
                choice = "Student";
                Intent intent = new Intent(MainActivity.this,
                        userLogin.class);
                intent.putExtra("ChoiceButton", choice);
                startActivity(intent);
            }
        });

        superAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice;
                choice = "Admin";
                Intent intent2 = new Intent(MainActivity.this,
                        userLogin.class);
                intent2.putExtra("ChoiceButton", choice);
                startActivity(intent2);
            }
        });

        adminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice;
                choice = "Faculty";
                Intent intent3 = new Intent(MainActivity.this,
                        userLogin.class);
                intent3.putExtra("ChoiceButton", choice);
                startActivity(intent3);
            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        register.class);
                startActivity(intent);
            }
        });

    }
}
