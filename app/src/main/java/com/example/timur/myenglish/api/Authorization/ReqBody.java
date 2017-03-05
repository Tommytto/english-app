package com.example.timur.myenglish.api.Authorization;

public class ReqBody {
    String login;
    String password;
    String code;

    public ReqBody(String login, String password, String code){
        this.login = login;
        this.password = password;
        this.code = code;
    }
}
