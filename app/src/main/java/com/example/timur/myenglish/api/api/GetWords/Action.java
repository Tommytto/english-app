package com.example.timur.myenglish.api.api.getWords;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Alex on 07.03.2017.
 */
public interface Action {
    @POST("/getwords")
    Call<List<Word>> getWords(@Body ReqBody request);
}

