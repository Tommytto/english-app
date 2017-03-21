package com.example.timur.myenglish.api.api.updateUnit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resp {

    @SerializedName("userid")
    @Expose
    private Integer userid;

    @SerializedName("unit")
    @Expose
    private Integer unit;

    @SerializedName("code")
    @Expose
    private Integer code;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}