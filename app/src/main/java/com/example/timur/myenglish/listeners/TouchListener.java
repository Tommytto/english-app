package com.example.timur.myenglish.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

import com.example.timur.myenglish.controllers.TaskController;

/**
 * Created by timur on 04.03.17.
 */

public class TouchListener implements View.OnTouchListener {

    private Activity activity;

    public TouchListener(Activity activity) {
        this.activity = activity;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Intent intent = new Intent(activity, TaskController.class);
        activity.startActivity(intent);
        return false;
    }
}
