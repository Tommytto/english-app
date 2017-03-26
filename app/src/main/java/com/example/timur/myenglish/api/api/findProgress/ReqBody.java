package com.example.timur.myenglish.api.api.findProgress;

public class ReqBody {
    private int userid;
    private int unit;
    private int current;
    private String code;

    public ReqBody(int userid, int unit, String code, int current) {
        this.userid = userid;
        this.unit = unit;
        this.code = code;
        this.current = current;
    }
}
