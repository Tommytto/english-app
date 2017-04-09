package com.example.timur.myenglish.model.api;

import android.app.Activity;

import com.example.timur.myenglish.api.api.auth.Action;
import com.example.timur.myenglish.api.api.auth.Auth;
import com.example.timur.myenglish.api.api.auth.ReqBody;
import com.example.timur.myenglish.controllers.Constants;
import com.example.timur.myenglish.controllers.Info;
import com.example.timur.myenglish.listeners.SignInListener;
import com.example.timur.myenglish.model.CashLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.timur.myenglish.controllers.Constants.UserTypes.FAIL_REQUEST;

/**
 * Created by timur on 25.02.17.
 */

public class AuthModel {
    private Auth auth;
    private Activity activity;

    public AuthModel(Activity activity) {
        this.activity = activity;
    }

    public Auth userAuth(String login, String password) {
        ReqBody req = new ReqBody(login, password, Constants.Codes.AUTH);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://the-people.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Action api = retrofit.create(Action.class);

        Call<Auth> call = api.register(req);
        call.enqueue(new Callback<Auth>() {
            public void onResponse(Call<Auth> call, Response<Auth> response) {
                auth = response.body();
                CashLoader.saveInt(Constants.Cash.UNIT_ID_CASH, auth.getUnit(), activity);
                CashLoader.saveInt(Constants.Cash.USER_ID_CASH, auth.getId(), activity);
                SignInListener.setIsUser(auth.getIsUser());

                if (auth.getIsUser() == Constants.UserTypes.IS_USER || auth.getIsUser() == Constants.UserTypes.IS_ADMIN) {
                    CashLoader.putAuthToken(Constants.Cash.AUTH_TOKEN_CASH, activity);
                    GetDateModel getDateModel = new GetDateModel();
                    getDateModel.getdate();
                } else {
                    SignInListener.choose();
                }

            }

            public void onFailure(Call<Auth> call, Throwable t) {
                SignInListener.setIsUser(FAIL_REQUEST);
                SignInListener.choose();
            }
        });

        return auth;
    }

}

