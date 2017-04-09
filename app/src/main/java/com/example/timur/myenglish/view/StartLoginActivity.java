package com.example.timur.myenglish.view;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.controllers.Constants;
import com.example.timur.myenglish.controllers.Info;
import com.example.timur.myenglish.listeners.SignInListener;
import com.example.timur.myenglish.model.CashLoader;
import com.example.timur.myenglish.model.api.GetDateModel;

import static android.content.ContentValues.TAG;

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

        etPassword.setTransformationMethod(new PasswordTransformationMethod());
        etPassword.setTypeface(Typeface.DEFAULT);

        Log.d(TAG, "cash lo " + CashLoader.loadInt(Constants.Cash.UNIT_ID_CASH, this));
        Log.d(TAG, "cash lo " + CashLoader.loadInt(Constants.Cash.USER_ID_CASH, this));
        Log.d(TAG, "cash lo " + CashLoader.checkAuthToken(Constants.Cash.AUTH_TOKEN_CASH, this));
        CashLoader.removeFromCash(Constants.Cash.AUTH_TOKEN_CASH, this);
        Log.d(TAG, "cash lo " + CashLoader.checkAuthToken(Constants.Cash.AUTH_TOKEN_CASH, this));
        if (CashLoader.checkAuthToken(Constants.Cash.AUTH_TOKEN_CASH, this)) {
            GetDateModel getDateModel = new GetDateModel();
            getDateModel.getdate();
        } else {
            btnSignIn.setOnClickListener(new SignInListener(this));
        }
    }
}
