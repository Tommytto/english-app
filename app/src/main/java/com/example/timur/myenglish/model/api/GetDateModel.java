package com.example.timur.myenglish.model.api;

import android.util.Log;

import com.example.timur.myenglish.api.api.getDate.Action;
import com.example.timur.myenglish.api.api.getDate.Date;
import com.example.timur.myenglish.api.api.getDate.ReqBody;
import com.example.timur.myenglish.controllers.Constants;
import com.example.timur.myenglish.listeners.SignInListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.timur.myenglish.controllers.Constants.UserTypes.FAIL_REQUEST;

/**
 * Created by timur on 25.02.17.
 */

public class GetDateModel {
    private Date date;

    public GetDateModel() {
    }

    public Date getdate () {
        ReqBody req = new ReqBody(0, Constants.Codes.GETDATE);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://the-people.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Action api = retrofit.create(Action.class);

        Call<List<Date>> call = api.getDate(req);
        call.enqueue(new Callback<List<Date>>() {
            public void onResponse(Call<List<Date>> call, Response<List<Date>> response) {
                date = response.body().get(0);
                Log.d(null, "HERE IS GETDATE API" + ((date == null)));
                SignInListener.setDateFromRes(date.getDate());
                    SignInListener.onSuccess();

            }
            public void onFailure(Call<List<Date>> call, Throwable t) {
                SignInListener.setIsUser(FAIL_REQUEST);
                SignInListener.onSuccess();
            }
        });

        return date;
    }

}

