package com.example.timur.myenglish.listeners;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.timur.myenglish.model.AuthModel;
import com.example.timur.myenglish.view.StartLoginActivity;
import com.example.timur.myenglish.view.UnitsActivity;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 25.02.17.
 */

public class SignInListener implements View.OnClickListener {

    private static final int FAIL_REQUEST = -2;
    private static final int IS_USER = 0;
    private static final int IS_ADMIN = 1;
    private static final int IS_NOT_USER = -1;
    private StartLoginActivity activity;
    private AuthModel authModel = new AuthModel();

    public SignInListener(StartLoginActivity activity) {
        this.activity = activity;
    }

    public void onClick(View v) {
        String userName = activity.getEtEmail().getText().toString();
        String userPass = activity.getEtPassword().getText().toString();

        int isUser = authModel.userAuth(userName, userPass);
        Log.d(TAG, "isUser " + isUser);
        Log.d(TAG, "userEmail " + activity.getEtEmail().getText());
        Log.d(TAG, "userPass " + activity.getEtPassword().getText());

        Intent intent = null;

        switch (isUser) {
            case IS_USER:
                activity.getTvLoginHint().setVisibility(TextView.INVISIBLE);
                intent = new Intent(activity, UnitsActivity.class);
                activity.startActivity(intent);
                break;
            case IS_ADMIN:
                activity.getTvLoginHint().setVisibility(TextView.INVISIBLE);
                intent = new Intent(activity, UnitsActivity.class);
                activity.startActivity(intent);
                break;
            case IS_NOT_USER:
                activity.getTvLoginHint().setText("Invalid password or login");
                activity.getTvLoginHint().setTextColor(Color.RED);
                activity.getTvLoginHint().setVisibility(TextView.VISIBLE);
                break;
            case FAIL_REQUEST:
                activity.getTvLoginHint().setText("Check internet connection");
                activity.getTvLoginHint().setTextColor(Color.RED);
                activity.getTvLoginHint().setVisibility(TextView.VISIBLE);
                break;
        }
    }
}
