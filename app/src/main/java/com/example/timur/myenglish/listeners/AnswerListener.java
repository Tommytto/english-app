package com.example.timur.myenglish.listeners;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.controllers.Constants;
import com.example.timur.myenglish.model.api.AddProgressModel;
import com.example.timur.myenglish.view.TaskBtnActivity;

import static android.content.ContentValues.TAG;
import static com.example.timur.myenglish.model.CashLoader.addToDailyLimit;
import static com.example.timur.myenglish.model.CashLoader.loadDailyLimit;
import static com.example.timur.myenglish.model.CashLoader.putLastTaskTime;

/**
 * Created by slava on 28.02.2017.
 */

public class AnswerListener implements View.OnClickListener {
    private int right;
    private int current;
    private static TaskBtnActivity activity;

    public AnswerListener(int right, int current, TaskBtnActivity activity) {
        this.right = right;
        this.current = current;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        int points = 0;
        ProgressBar progress_preloader = (ProgressBar) activity.findViewById(R.id.progress_preloader);
        progress_preloader.setVisibility(View.VISIBLE);

        for (int i = 0; i < 4; i++) {
            activity.getButtons()[i].setEnabled(false);
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
        int tasksPerDay = loadDailyLimit(Constants.Cash.TASKS_DAILY_LIMIT_CASH, activity);
        RelativeLayout layoutWords = (RelativeLayout) activity.findViewById(R.id.layoutWords);
        ProgressBar task_progress_bar = (ProgressBar) activity.findViewById(R.id.task_progress_bar);
        ProgressBar progress_preloader = (ProgressBar) activity.findViewById(R.id.progress_preloader);

        progress_preloader.setVisibility(View.INVISIBLE);
        addToDailyLimit(Constants.Cash.TASKS_DAILY_LIMIT_CASH, activity);
        task_progress_bar.incrementProgressBy(10);

        if (tasksPerDay >= 9) {
            putLastTaskTime(Constants.Cash.LAST_TASK_TIME_CASH, activity);
            layoutWords.setOnClickListener(new ToUnitsListener(activity));
        } else {
            layoutWords.setOnClickListener(new NextTaskListener(layoutWords,activity));
        }
    }
}
