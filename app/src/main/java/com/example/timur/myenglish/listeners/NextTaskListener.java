package com.example.timur.myenglish.listeners;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.controllers.Configs;

import static com.example.timur.myenglish.controllers.Configs.timeNow;
import static com.example.timur.myenglish.model.CashLoader.loadDailyLimit;

/**
 * Created by timur on 04.03.17.
 */

public class NextTaskListener implements View.OnClickListener {

    private Activity activity;
    private View view;

    public NextTaskListener( View view, Activity activity) {
        this.activity = activity;
        this.view = view;
    }

    @Override
    public void onClick(View v) {
        view.setOnClickListener(null);
        Configs.hasProgress(activity);
    }
}
