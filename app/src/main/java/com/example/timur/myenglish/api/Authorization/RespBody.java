package com.example.timur.myenglish.api.Authorization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RespBody {

    @SerializedName("isUser")
    @Expose
    private Integer isUser;

    public Integer getIsUser() {
        return isUser;
    }

    public void setIsUser(Integer isUser) {
        this.isUser = isUser;
    }

}