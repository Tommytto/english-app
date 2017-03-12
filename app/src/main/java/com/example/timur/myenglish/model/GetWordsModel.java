package com.example.timur.myenglish.model;
import android.util.Log;

import com.example.timur.myenglish.api.api.GetWords.RespBody;
import com.example.timur.myenglish.api.api.GetWords.Action;
import com.example.timur.myenglish.api.api.GetWords.ReqBody;
import com.example.timur.myenglish.listeners.SignInListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by Alex on 07.03.2017.
 */

public class GetWordsModel {

    public GetWordsModel() {

    }

    public void getWords(){
        ReqBody req = new ReqBody("ROPEAeFcq4");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://the-people.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Action api = retrofit.create(Action.class);
        Call<RespBody> call = api.getWords(req);

        call.enqueue(new Callback<RespBody>() {
            public void onResponse(Call<RespBody> call, Response<RespBody> response) {
                Log.d(TAG,"words, " + response.body().getDef1());
            }
            public void onFailure(Call<RespBody> call, Throwable t) {

            }
        });
    }
}
