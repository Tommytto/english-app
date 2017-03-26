package com.example.timur.myenglish.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.timur.myenglish.view.UnitsActivity;

/**
 * Created by root on 26.03.17.
 */

public class ToUnitsListener implements View.OnClickListener {

    private Activity activity;

    public ToUnitsListener (Activity activity) {
        this.activity = activity;
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(activity, UnitsActivity.class);
        activity.startActivity(intent);
    }
}
