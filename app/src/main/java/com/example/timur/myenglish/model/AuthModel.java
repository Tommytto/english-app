package com.example.timur.myenglish.model;

import android.util.Log;

import com.example.timur.myenglish.api.api.Authorization.Action;
import com.example.timur.myenglish.api.api.Authorization.ReqBody;
import com.example.timur.myenglish.api.api.Authorization.RespBody;
import com.example.timur.myenglish.listeners.SignInListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 25.02.17.
 */

public class AuthModel {
    private int isAuth;
    private static final int FAIL_REQUEST = -2;
    private static final int IS_USER = 1;
    private static final int IS_NOT_USER = 0;

    public AuthModel () {
    }

    public void userAuth (String login, String password) {
        ReqBody req = new ReqBody(login, password, "ZhmCGGXeey");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://the-people.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Action api = retrofit.create(Action.class);

        Call<RespBody> call = api.register(req);
        call.enqueue(new Callback<RespBody>() {
            public void onResponse(Call<RespBody> call, Response<RespBody> response) {
                isAuth = response.body().getIsUser();
                SignInListener.onSuccess(isAuth);
            }
            public void onFailure(Call<RespBody> call, Throwable t) {
                SignInListener.onSuccess(FAIL_REQUEST);
            }
        });
    };

}

