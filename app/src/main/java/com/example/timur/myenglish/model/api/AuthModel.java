package com.example.timur.myenglish.model.api;

import com.example.timur.myenglish.api.api.auth.Action;
import com.example.timur.myenglish.api.api.auth.Auth;
import com.example.timur.myenglish.api.api.auth.ReqBody;
import com.example.timur.myenglish.controllers.Constants;
import com.example.timur.myenglish.controllers.Info;
import com.example.timur.myenglish.listeners.SignInListener;

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

    public AuthModel () {
    }

    public Auth userAuth (String login, String password) {
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
                Info.setUnit(auth.getUnit());
                Info.setUserId(auth.getId());
                SignInListener.setIsUser(auth.getIsUser());

                    if (auth.getIsUser() == Constants.UserTypes.IS_USER) {
                        GetDateModel getDateModel = new GetDateModel();
                        getDateModel.getdate();
                    }
                    else SignInListener.choose();

            }
            public void onFailure(Call<Auth> call, Throwable t) {
                SignInListener.setIsUser(FAIL_REQUEST);
                SignInListener.choose();
            }
        });

        return auth;
    }

}

