package com.example.timur.myenglish.api.api.addProgress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resp {

    @SerializedName("userid")
    @Expose
    private Integer userid;

    @SerializedName("wordid")
    @Expose
    private Integer wordid;

    @SerializedName("points")
    @Expose
    private Integer points;

    @SerializedName("code")
    @Expose
    private String code;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}