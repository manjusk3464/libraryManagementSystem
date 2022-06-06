package com.android.library.management.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static ToastUtil instance;
    public String message;
    Context context;

    public ToastUtil(String message, Context context) {
        try {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        this.message = message;
        this.context = context;
    }

    public static ToastUtil getInstance(String message, Context context) {
        if (instance == null) {
            instance = new ToastUtil(message, context);
        }
        return instance;
    }
}
