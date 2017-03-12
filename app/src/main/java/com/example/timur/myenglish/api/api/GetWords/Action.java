package com.example.timur.myenglish.api.api.GetWords;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Alex on 07.03.2017.
 */
public interface Action {
    @POST("/getwords")
    Call<RespBody> getWords(@Body ReqBody request);
}

