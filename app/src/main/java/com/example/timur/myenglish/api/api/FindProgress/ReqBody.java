package com.example.timur.myenglish.api.api.findProgress;

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
