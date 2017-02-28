package com.example.timur.myenglish.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.listeners.AnswerListener;
import com.example.timur.myenglish.model.SQueryFactory;
import com.example.timur.myenglish.model.Word;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 18.02.17.
 */

public class TaskActivity_2 extends Activity {
    private Button[] buttons = new Button[4];

    public Button[] getButtons() {
        return buttons;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task2_main);

        SQueryFactory unitModel = new SQueryFactory(this);

        Word word = unitModel.getWord();
        ArrayList<Word> words = unitModel.getWords(word);
        Log.d(TAG, "TaskActivity; Used word:" + word.getLang1());
        Intent intentParent = getIntent();

        TextView textTask = (TextView) findViewById(R.id.tvTaskDecription);

        buttons[0] = (Button) findViewById(R.id.btnChoose1);
        buttons[1] = (Button) findViewById(R.id.btnChoose2);
        buttons[2] = (Button) findViewById(R.id.btnChoose3);
        buttons[3] = (Button) findViewById(R.id.btnChoose4);


        int right = -1;
        for (int i = 0; i < 4; i++){
            buttons[i].setText(words.get(i).getLang2());
            if (words.get(i).equals(word))
                right = i;
            buttons[i].setOnClickListener(new AnswerListener(right, i, this));
        }

        textTask.setText(word.getLang1());

    }
}
