package com.example.timur.myenglish.api.Authorization;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by timur on 25.02.17.
 */

public interface Action {
    @POST("/auth")
    Call<RespBody> register(@Body ReqBody request);
}

