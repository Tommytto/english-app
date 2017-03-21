package com.example.timur.myenglish.model.api;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.example.timur.myenglish.api.api.findProgress.Action;
import com.example.timur.myenglish.api.api.findProgress.ReqBody;
import com.example.timur.myenglish.api.api.findProgress.Resp;
import com.example.timur.myenglish.controllers.Configs;
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

public class FindProgressModel {

    public void execute (final Activity activity) {
        final ReqBody req = new ReqBody(Info.getUserId(), Info.getCurrentUnit(), Constants.Codes.FINDPROGRESS, Info.getCurrentWordId());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://the-people.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Action api = retrofit.create(Action.class);

        Call<List<Resp>> call = api.findprogress(req);
        call.enqueue(new Callback<List<Resp>>() {
            public void onResponse(Call<List<Resp>> call, Response<List<Resp>> response) {
                if (response.body().size() == 0){
                    Toast.makeText(activity, "Unit is finished", Toast.LENGTH_LONG);
                    if (Info.getCurrentUnit() == Info.getUnit() && Info.getUnit() < Constants.MAXUNIT){
                        Info.setUnit(Info.getCurrentUnit() + 1);
                        new UpdateUnitModel().execute(activity);
                    }
                }
                else {
                    Info.setCurrentWordId(response.body().get(0).getWordid());
                    Configs.generateTask(activity);
                }
            }
            public void onFailure(Call<List<Resp>> call, Throwable t) {
                Log.d(TAG, "onFailure: UNSUCCESSFULLY:(");
            }
        });
    }
}
