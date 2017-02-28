package com.example.timur.myenglish.listeners;

import android.graphics.Color;
import android.view.View;

import com.example.timur.myenglish.view.TaskWButActivity;

/**
 * Created by slava on 28.02.2017.
 */

public class AnswerListener implements View.OnClickListener {
    private int right;
    private int current;
    private TaskWButActivity activity;

    public AnswerListener(int right, int current, TaskWButActivity activity) {
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

        new UChooseListener(activity).onClick(v);

//        Intent intent = new Intent(activity, TaskWButActivity.class);
//        activity.startActivity(intent);
    }

}
