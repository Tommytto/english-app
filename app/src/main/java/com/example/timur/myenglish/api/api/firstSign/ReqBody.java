package com.example.timur.myenglish.api.api.firstSign;

public class ReqBody {
    private int userid;
    private String code;

    public ReqBody(int userid, String code) {
        this.userid = userid;
        this.code = code;
    }
}
