package com.example.timur.myenglish.model.api;

import android.util.Log;

import com.example.timur.myenglish.api.api.addProgress.Action;
import com.example.timur.myenglish.api.api.addProgress.ReqBody;
import com.example.timur.myenglish.api.api.addProgress.Resp;
import com.example.timur.myenglish.controllers.Constants;
import com.example.timur.myenglish.controllers.Info;
import com.example.timur.myenglish.listeners.AnswerListener;
import com.example.timur.myenglish.view.TaskBtnActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by slava on 20.03.2017.
 */

public class AddProgressModel {
    public void execute (final int points, final int current, final TaskBtnActivity activity) {
        final ReqBody req = new ReqBody(Info.getUserId(), Info.getCurrentWordId(), points, Constants.Codes.ADDPROGRESS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://the-people.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Action api = retrofit.create(Action.class);

        Call<Resp> call = api.addprogress(req);
        call.enqueue(new Callback<Resp>() {
            public void onResponse(Call<Resp> call, Response<Resp> response) {
                AnswerListener.addNextTaskListener();
            }
            public void onFailure(Call<Resp> call, Throwable t) {
                Log.d(TAG, "onFailure: UNSUCCESSFULLY:(");
                Log.d(TAG, "userid: " + Info.getUserId());
                Log.d(TAG, "wordid: " + Info.getCurrentWordId());
                Log.d(TAG, "points: " + points);
                Log.d(TAG, "code: " + Constants.Codes.ADDPROGRESS);
            }
        });
    }
}
