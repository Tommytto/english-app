package com.example.timur.myenglish.listeners;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timur.myenglish.model.AuthModel;
import com.example.timur.myenglish.view.TaskActivity_2;
import com.example.timur.myenglish.view.UnitsActivity;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 25.02.17.
 */

public class btnSignIn  implements View.OnClickListener {

    private static final int FAIL_REQUEST = -1;
    private static final int IS_USER = 1;
    private static final int IS_NOT_USER = 0;
    private EditText etEmail;
    private EditText etPassword;
    private TextView tvLoginHint;
    private Context context;
    private AuthModel authModel = new AuthModel();

    public btnSignIn (EditText etEmail, EditText etPassword, TextView tvLoginHint, Context context) {
        this.etEmail = etEmail;
        this.etPassword = etPassword;
        this.context = context;
        this.tvLoginHint = tvLoginHint;
    }

    public void onClick(View v) {
        String userName = etEmail.getText().toString();
        String userPass = etPassword.getText().toString();

        int isUser = authModel.userAuth(userName, userPass);
        Log.d(TAG,"isUser " + isUser);
        Log.d(TAG,"userEmail " + etEmail.getText());
        Log.d(TAG,"userPass " + etPassword.getText());
        switch (isUser) {
            case IS_USER:
                tvLoginHint.setVisibility(TextView.INVISIBLE);
                Intent intent = new Intent(context, UnitsActivity.class);
                context.startActivity(intent);
                break;
            case IS_NOT_USER:
                tvLoginHint.setText("Invalid password or login");
                tvLoginHint.setTextColor(Color.RED);
                tvLoginHint.setVisibility(TextView.VISIBLE);
                break;
            case FAIL_REQUEST:
                tvLoginHint.setText("Check internet connection");
                tvLoginHint.setTextColor(Color.RED);
                tvLoginHint.setVisibility(TextView.VISIBLE);
                break;
        }
    }
}
