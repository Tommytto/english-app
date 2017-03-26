package com.example.timur.myenglish.view;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.listeners.SignInListener;

/**
 * Created by timur on 25.02.17.
 */

public class StartLoginActivity extends Activity {

    private EditText etEmail;
    private EditText etPassword;

    public TextView getTvLoginHint() {
        return tvLoginHint;
    }

    public EditText getEtPassword() {
        return etPassword;
    }

    public EditText getEtEmail() {
        return etEmail;
    }

    private TextView tvLoginHint;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);

        tvLoginHint = (TextView) findViewById(R.id.tvLoginHint);

        etPassword.setTypeface(Typeface.DEFAULT);
        etPassword.setTransformationMethod(new PasswordTransformationMethod());

        btnSignIn.setOnClickListener(new SignInListener(this));



    }
}
