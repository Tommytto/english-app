package com.example.timur.myenglish.listeners;

import android.graphics.Color;
import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.model.api.AddProgressModel;
import com.example.timur.myenglish.view.TaskBtnActivity;

import static android.content.ContentValues.TAG;
import static com.example.timur.myenglish.model.CashLoader.addToDailyLimit;
import static com.example.timur.myenglish.model.CashLoader.loadDailyLimit;

/**
 * Created by slava on 28.02.2017.
 */

public class AnswerListener implements View.OnClickListener {
    private static int right;
    private static int current;
    private static TaskBtnActivity activity;

    public AnswerListener(int right, int current, TaskBtnActivity activity) {
        this.right = right;
        this.current = current;
        this.activity = activity;
        Log.d(TAG, "Current btn click " + current);
        Log.d(TAG, "Current btn click right " + right);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "Current btn view " + v);
        int points = 0;
        ProgressBar progress_preloader = (ProgressBar) activity.findViewById(R.id.progress_preloader);

        progress_preloader.setVisibility(View.VISIBLE);
        for (int i = 0; i < 4; i++) {
            activity.getButtons()[i].setEnabled(false);
        }

        if (right == current) {
            activity.getButtons()[current].setBackgroundColor(Color.GREEN);

        } else {
            activity.getButtons()[current].setBackgroundColor(Color.RED);

        }
        if (right == current) {
            points = 1;
        } else {
            points = -3;
        }

        new AddProgressModel().execute(points, current, activity);

        // TODO: 20.03.2017
//        Update Remote

//        for (int i = 0; i < 4; i++){
//            activity.getButtons()[i].setEnabled(false);
//        }
//
//        RelativeLayout layoutWords = (RelativeLayout) activity.findViewById(R.id.layoutWords);
//        layoutWords.setOnTouchListener(new NextTaskListener(activity));

    }

    public static void addNextTaskListener() {
        int tasksPerDay = loadDailyLimit("dailyLimit", activity);
        RelativeLayout layoutWords = (RelativeLayout) activity.findViewById(R.id.layoutWords);
        ProgressBar task_progress_bar = (ProgressBar) activity.findViewById(R.id.task_progress_bar);
        ProgressBar progress_preloader = (ProgressBar) activity.findViewById(R.id.progress_preloader);

        progress_preloader.setVisibility(View.INVISIBLE);

        addToDailyLimit("dailyLimit", activity);


        if (tasksPerDay == 10) {
            layoutWords.setOnClickListener(new ToUnitsListener(activity));
        } else {
            layoutWords.setOnTouchListener(new NextTaskListener(layoutWords,activity));
        }
    }
}
