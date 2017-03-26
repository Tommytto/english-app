package com.example.timur.myenglish.model.api;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.example.timur.myenglish.api.api.updateUnit.Action;
import com.example.timur.myenglish.api.api.updateUnit.ReqBody;
import com.example.timur.myenglish.api.api.updateUnit.Resp;
import com.example.timur.myenglish.controllers.Constants;
import com.example.timur.myenglish.controllers.Info;

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

public class UpdateUnitModel {

    public void execute (final Activity activity) {
        final ReqBody req = new ReqBody(Info.getUserId(), Info.getUnit(), Constants.Codes.UPDATEUNIT);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://the-people.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Action api = retrofit.create(Action.class);

        Call<List<Resp>> call = api.updateunit(req);
        call.enqueue(new Callback<List<Resp>>() {
            public void onResponse(Call<List<Resp>> call, Response<List<Resp>> response) {
                Toast.makeText(activity, "New unit is available", Toast.LENGTH_LONG);
            }
            public void onFailure(Call<List<Resp>> call, Throwable t) {
                Log.d(TAG, "onFailure: UNSUCCESSFULLY:(");
            }
        });
    }
}
