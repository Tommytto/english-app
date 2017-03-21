package com.example.timur.myenglish.api.api.auth;

public class ReqBody {
    private String login;
    private String password;
    private String code;

    public ReqBody(String login, String password, String code){
        this.login = login;
        this.password = password;
        this.code = code;
    }
}
