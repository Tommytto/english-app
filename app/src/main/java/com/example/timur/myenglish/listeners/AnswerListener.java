package com.example.timur.myenglish.listeners;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import com.example.timur.myenglish.view.TaskActivity_2;

/**
 * Created by slava on 28.02.2017.
 */

public class AnswerListener implements View.OnClickListener {
    private int right;
    private int current;
    private TaskActivity_2 activity;

    public AnswerListener(int right, int current, TaskActivity_2 activity) {
        this.right = right;
        this.current = current;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        if (right == current){
            activity.getButtons()[current].setBackgroundColor(Color.GREEN);
        }
        else {
            activity.getButtons()[current].setBackgroundColor(Color.RED);
        }
        for (int i = 0; i < 4; i++){
            activity.getButtons()[i].setEnabled(false);
        }

        Intent intent = new Intent(activity, TaskActivity_2.class);
        activity.startActivity(intent);
    }

}
