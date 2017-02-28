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
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 18.02.17.
 */

public class TaskWButActivity extends Activity {
    private static int NOT_IDENTIFIED = -1;
    private static final int TASK_TRANSLATE = 1;
    private static final int TASK_FILL_GAPS = 2;
    private static final int TASK_MEANING = 3;

    private Button[] buttons = new Button[4];

    public Button[] getButtons() {
        return buttons;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task2_main);

        Intent intent = getIntent();
        int mode = intent.getIntExtra("mode", NOT_IDENTIFIED);

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

        Random rnd = new Random();

        int right = -1;
        switch (mode){
            case TASK_TRANSLATE:
                for (int i = 0; i < 4; i++){
                    buttons[i].setText(words.get(i).getLang2());
                    if (words.get(i).equals(word))
                        right = i;
                    buttons[i].setOnClickListener(new AnswerListener(right, i, this));
                }
                textTask.setText(word.getLang1());
                break;
            case TASK_FILL_GAPS:
                for (int i = 0; i < 4; i++){
                    buttons[i].setText(words.get(i).getLang1());
                    if (words.get(i).equals(word))
                        right = i;
                    buttons[i].setOnClickListener(new AnswerListener(right, i, this));
                }
                if (!word.getSent2().equals("")){
                    int i = rnd.nextInt(2);
                    if (i == 0)
                        textTask.setText(word.getSent1().replace(word.getLang1(), "___"));
                    else
                        textTask.setText(word.getSent2().replace(word.getLang1(), "___"));
                }
                else
                    textTask.setText(word.getSent1());
                break;
            case TASK_MEANING:
                for (int i = 0; i < 4; i++){
                    buttons[i].setText(words.get(i).getLang1());
                    if (words.get(i).equals(word))
                        right = i;
                    buttons[i].setOnClickListener(new AnswerListener(right, i, this));
                }
                textTask.setText(word.getDef1());
                break;
        }

    }
}
