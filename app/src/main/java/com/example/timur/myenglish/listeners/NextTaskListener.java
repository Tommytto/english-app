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

    public NextTaskListener(Activity activity) {
        this.activity = activity;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
//        Configs.isFinished(Info.getCurrentUnit(), activity);
        Configs.hasProgress(activity);
        return false;
    }
}
