package com.example.timur.myenglish.api.api.getDate;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by timur on 25.02.17.
 */

public interface Action {
    @POST("/getdate")
    Call<List<Date>> getDate(@Body ReqBody request);
}

