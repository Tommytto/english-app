package com.example.timur.myenglish.api.api.addProgress;

public class ReqBody {
    private int userid;
    private int wordid;
    private int points;
    private String code;

    public ReqBody(int userid, int wordid, int points, String code) {
        this.userid = userid;
        this.wordid = wordid;
        this.points = points;
        this.code = code;
    }
}
