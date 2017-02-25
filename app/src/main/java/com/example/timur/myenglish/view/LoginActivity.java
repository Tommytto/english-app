package com.example.timur.myenglish.view;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.listeners.btnSignIn;

/**
 * Created by timur on 25.02.17.
 */

public class LoginActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btnSignIn = (Button) findViewById(R.id.btnSignIn);

        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etPassword = (EditText) findViewById(R.id.etPassword);

        TextView tvLoginHint = (TextView) findViewById(R.id.tvLoginHint);

        etPassword.setTypeface(Typeface.DEFAULT);
        etPassword.setTransformationMethod(new PasswordTransformationMethod());

        btnSignIn.setOnClickListener(new btnSignIn(etEmail, etPassword, tvLoginHint, this));
    }
}
