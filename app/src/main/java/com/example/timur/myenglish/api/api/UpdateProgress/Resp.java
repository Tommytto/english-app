package com.example.timur.myenglish.api.api.updateProgress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resp {

    @SerializedName("code")
    @Expose
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}