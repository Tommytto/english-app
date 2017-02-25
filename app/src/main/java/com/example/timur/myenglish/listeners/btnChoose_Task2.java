package com.example.timur.myenglish.listeners;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.example.timur.myenglish.view.TaskActivity_2;

/**
 * Created by timur on 18.02.17.
 */

public class btnChoose_Task2 implements View.OnClickListener {

    private TaskActivity_2 task2 = new TaskActivity_2();

    public void onClick (View v) {
        Button pressedBtn = (Button)v;
        String answer = pressedBtn.getText().toString();
        int btnId = pressedBtn.getId();

        boolean isRightAnswer = task2.isRightAnswer(answer);

        if (isRightAnswer) {
            pressedBtn.setBackgroundColor(Color.GREEN);
        }
    }
}
