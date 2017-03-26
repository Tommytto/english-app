package com.example.timur.myenglish.api.api.updateUnit;

public class ReqBody {
    private int userid;
    private int unit;
    private String code;

    public ReqBody(int userid, int unit, String code) {
        this.userid = userid;
        this.unit = unit;
        this.code = code;
    }
}
