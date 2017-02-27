package com.example.timur.myenglish.api.Authorization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RespBody {

    @SerializedName("isUser")
    @Expose
    private Integer isUser;

    @SerializedName("id")
    @Expose
    private Integer id;

    public Integer getIsUser() {
        return isUser;
    }

    public void setIsUser(Integer isUser) {
        this.isUser = isUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}