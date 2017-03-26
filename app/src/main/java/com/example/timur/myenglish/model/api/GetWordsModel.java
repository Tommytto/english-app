package com.example.timur.myenglish.model.api;

import com.example.timur.myenglish.api.api.getWords.Action;
import com.example.timur.myenglish.api.api.getWords.ReqBody;
import com.example.timur.myenglish.api.api.getWords.Word;
import com.example.timur.myenglish.listeners.SignInListener;
import com.example.timur.myenglish.model.db.SQLi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 07.03.2017.
 */

public class GetWordsModel {

    public GetWordsModel() {

    }

    public void getWords(){
        ReqBody req = new ReqBody("ROPEAeFcq4");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://the-people.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Action api = retrofit.create(Action.class);
        Call<List<Word>> call = api.getWords(req);

        call.enqueue(new Callback<List<Word>>() {
            public void onResponse(Call<List<Word>> call, Response<List<Word>> response) {
                List<Word> words = response.body();
                SQLi sqli = new SQLi(SignInListener.getActivity());
                for (int i = 0; i < words.size(); i++){
                    sqli.addWord(new com.example.timur.myenglish.model.Word(
                            words.get(i).getNum(),
                            words.get(i).getLang1(),
                            words.get(i).getDef1(),
                            words.get(i).getLang2(),
                            words.get(i).getDef2(),
                            words.get(i).getSynid(),
                            words.get(i).getOppid(),
                            words.get(i).getPos(),
                            words.get(i).getSent1(),
                            words.get(i).getSent2(),
                            words.get(i).getUnit()
                    ));
                }
                SignInListener.choose();

            }
            public void onFailure(Call<List<Word>> call, Throwable t) {

            }
        });
    }
}
