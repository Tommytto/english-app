package com.example.timur.myenglish.api.api.firstSign;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by timur on 25.02.17.
 */

public interface Action {
    @POST("/firstsign")
    Call<List<Resp>> firstsign(@Body ReqBody request);
}

