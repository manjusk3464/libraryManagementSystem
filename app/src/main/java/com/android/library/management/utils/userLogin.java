package com.android.library.management.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.library.management.R;
import com.android.library.management.helper.LoginDataBaseHelper;

public class userLogin extends AppCompatActivity {

    EditText email, password;
    TextView register;
    Button login;
    LoginDataBaseHelper db;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        context = this;
        email = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.RegisterAccount);
        db = new LoginDataBaseHelper(context);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),
                        com.android.library.management.utils.register.class);

                startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (Email.isEmpty() || pass.isEmpty()) {
                    // If email and pass not entered will throw a toast
                    Toast.makeText(userLogin.this, "Enter your user name and password!", Toast.LENGTH_SHORT).show();
                } else {
                    // Checks if the user has an account
                    Boolean loginCheck = db.loginCheck(Email, pass);
                    if (loginCheck == true) {
                        Intent intent2 = getIntent();
                        String choice = intent2.getStringExtra("ChoiceButton");
                        Toast.makeText(userLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        email.setText("");
                        password.setText("");
                        Intent intent = new Intent(userLogin.this,
                                LibraryMenu.class);
                        intent.putExtra("userChoice", choice);
                        startActivity(intent);
                    } else {
                        Toast.makeText(userLogin.this, "Invalid user name or password!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}
