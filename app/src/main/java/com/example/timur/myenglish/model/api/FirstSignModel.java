package com.example.timur.myenglish.model.api;

import android.util.Log;

import com.example.timur.myenglish.api.api.firstSign.Action;
import com.example.timur.myenglish.api.api.firstSign.ReqBody;
import com.example.timur.myenglish.api.api.firstSign.Resp;
import com.example.timur.myenglish.controllers.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by slava on 20.03.2017.
 */

public class FirstSignModel {
    public void execute(int userid) {
        ReqBody req = new ReqBody(userid, Constants.Codes.FIRSTSIGN);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://the-people.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Action api = retrofit.create(Action.class);

        Call<List<Resp>> call = api.firstsign(req);
        call.enqueue(new Callback<List<Resp>>() {
            public void onResponse(Call<List<Resp>> call, Response<List<Resp>> response) {
                GetWordsModel model = new GetWordsModel();
                Log.d(TAG, "onResponse: 1");
                model.getWords();
            }
            public void onFailure(Call<List<Resp>> call, Throwable t) {
                GetWordsModel model = new GetWordsModel();
                Log.d(TAG, "onResponse: 2");
                model.getWords();
            }
        });

    }

}
