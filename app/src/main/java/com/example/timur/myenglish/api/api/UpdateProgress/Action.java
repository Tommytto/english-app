package com.example.timur.myenglish.api.api.updateProgress;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by timur on 25.02.17.
 */

public interface Action {
    @POST("/updateprogress")
    Call<Resp> updateprogress(@Body ReqBody request);
}

