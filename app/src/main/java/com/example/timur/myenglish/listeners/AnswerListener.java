package com.example.timur.myenglish.listeners;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.view.TaskBtnActivity;

/**
 * Created by slava on 28.02.2017.
 */

public class AnswerListener implements View.OnClickListener {
    private int right;
    private int current;
    private TaskBtnActivity activity;

    public AnswerListener(int right, int current, TaskBtnActivity activity) {
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

        RelativeLayout layoutWords = (RelativeLayout) activity.findViewById(R.id.layoutWords);
        layoutWords.setOnTouchListener(new TouchListener(activity));

//        Intent intent = new Intent(activity, TaskBtnActivity.class);
//        activity.startActivity(intent);
    }

}
