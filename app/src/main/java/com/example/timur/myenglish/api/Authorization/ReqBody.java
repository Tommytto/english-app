package com.example.timur.myenglish.api.Authorization;

public class ReqBody {
    String login;
    String password;

    public ReqBody(String login, String password){
        this.login = login;
        this.password = password;
    }
}
