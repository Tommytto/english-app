package com.example.timur.myenglish.listeners;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;

import com.example.timur.myenglish.controllers.Configs;

/**
 * Created by timur on 04.03.17.
 */

public class NextTaskListener implements View.OnTouchListener {

    private Activity activity;
    private View view;

    public NextTaskListener( View view, Activity activity) {
        this.activity = activity;
        this.view = view;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
//        Configs.isFinished(Info.getCurrentUnit(), activity);
        view.setOnClickListener(null);
        Configs.hasProgress(activity);
        return false;
    }
}
