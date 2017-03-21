package com.example.timur.myenglish.listeners;

import android.view.View;

import com.example.timur.myenglish.model.api.AddProgressModel;
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
        int a = 0;

        if (right == current){
//            activity.getButtons()[current].setBackgroundColor(Color.GREEN);
            a = 1;
        }
        else {
//            activity.getButtons()[current].setBackgroundColor(Color.RED);
            a = -3;
        }

      // TODO: 20.03.2017
//        Update Remote
        new AddProgressModel().execute(a, current, activity);

//        for (int i = 0; i < 4; i++){
//            activity.getButtons()[i].setEnabled(false);
//        }
//
//        RelativeLayout layoutWords = (RelativeLayout) activity.findViewById(R.id.layoutWords);
//        layoutWords.setOnTouchListener(new TouchListener(activity));

    }

}
