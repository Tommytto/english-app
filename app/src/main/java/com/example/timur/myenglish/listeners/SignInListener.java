package com.example.timur.myenglish.listeners;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.api.api.auth.Auth;
import com.example.timur.myenglish.controllers.Configs;
import com.example.timur.myenglish.controllers.Constants;
import com.example.timur.myenglish.controllers.Info;
import com.example.timur.myenglish.model.CashLoader;
import com.example.timur.myenglish.model.api.AuthModel;
import com.example.timur.myenglish.model.api.FirstSignModel;
import com.example.timur.myenglish.model.db.SQLi;
import com.example.timur.myenglish.view.AdminActivity;
import com.example.timur.myenglish.view.StartLoginActivity;
import com.example.timur.myenglish.view.UnitsActivity;
import com.example.timur.myenglish.model.CashLoader;


import static android.content.ContentValues.TAG;
import static com.example.timur.myenglish.model.CashLoader.addToDailyLimit;
import static com.example.timur.myenglish.model.CashLoader.loadString;
import static com.example.timur.myenglish.model.CashLoader.saveString;

/**
 * Created by timur on 25.02.17.
 */

public class SignInListener implements View.OnClickListener {

    private static StartLoginActivity activity;
    private AuthModel authModel;
    private static int isUser;
    private static String dateFromRes;

    public static StartLoginActivity getActivity() {
        return activity;
    }

    public static void setDateFromRes(String dateFromRes) {
        SignInListener.dateFromRes = dateFromRes;
    }

    public static void setIsUser(int isUser) {
        SignInListener.isUser = isUser;
    }

    public SignInListener(StartLoginActivity activity) {
        this.activity = activity;
        this.authModel = new AuthModel(activity);
    }

    public void onClick(View v) {

        String userName = activity.getEtEmail().getText().toString();
        String userPass = activity.getEtPassword().getText().toString();
        ProgressBar login_preloader = (ProgressBar) activity.findViewById(R.id.login_preloader);

        login_preloader.setVisibility(View.VISIBLE);
        Auth auth = authModel.userAuth(userName, userPass);

        if (auth != null) {
            Log.d(TAG, "Id " + auth.getId());
            Log.d(TAG, "IsUser " + auth.getIsUser());
            Log.d(TAG, "Unit " + auth.getUnit());
        }

    }

    public static void update() {
        saveString("table_words", Configs.timeNow(), activity);
        saveString("user", String.valueOf(Info.getUserId()), activity);

        SQLi sq = new SQLi(activity);
        sq.deleteAll();

        FirstSignModel model = new FirstSignModel();
        model.execute(Info.getUserId());

//        GetWordsModel model = new GetWordsModel();
//        model.getWords();
    }

    public static void onSuccess() {

        Info.setUnit(CashLoader.loadInt(Constants.Cash.UNIT_ID_CASH, activity));
        Info.setUserId(CashLoader.loadInt(Constants.Cash.USER_ID_CASH, activity));
//        Проверка-загрузка words
        if (loadString("table_words", activity) != null &&
                loadString("user", activity) != null) {
//            Перевод даты(из запроса и из кэша) в int, из второго вычитаем первое, сравниваем с 0

            int fromCash = Configs.timeToInt(loadString("table_words", activity));
            int fromResponse = Configs.timeToInt(dateFromRes);

            if (fromCash - fromResponse <= 0
                    || Integer.parseInt(loadString("user", activity)) != Info.getUserId()) {
                update();
                Log.d(TAG, "1");
            } else {
                SignInListener.choose();
            }
            Log.d(TAG, "2");

        } else {
            update();
            Log.d(TAG, "3");
        }
    }

    public static void choose() {
        Intent intent;
        ProgressBar login_preloader = (ProgressBar) activity.findViewById(R.id.login_preloader);
        login_preloader.setVisibility(View.INVISIBLE);

        switch (isUser) {
            case Constants.UserTypes.IS_USER:
                activity.getTvLoginHint().setVisibility(TextView.INVISIBLE);
                intent = new Intent(activity, UnitsActivity.class);
                activity.startActivity(intent);
                break;
            case Constants.UserTypes.IS_ADMIN:
                activity.getTvLoginHint().setVisibility(TextView.INVISIBLE);
                intent = new Intent(activity, AdminActivity.class);
                activity.startActivity(intent);
                break;
            case Constants.UserTypes.IS_NOT_USER:
                activity.getTvLoginHint().setText("Invalid password or login");
                activity.getTvLoginHint().setTextColor(Color.RED);
                activity.getTvLoginHint().setVisibility(TextView.VISIBLE);
                break;
            case Constants.UserTypes.FAIL_REQUEST:
                activity.getTvLoginHint().setText("Check internet connection");
                activity.getTvLoginHint().setTextColor(Color.RED);
                activity.getTvLoginHint().setVisibility(TextView.VISIBLE);
                break;
        }
    }
}
