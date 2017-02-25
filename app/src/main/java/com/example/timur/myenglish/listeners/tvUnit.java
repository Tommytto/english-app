package com.example.timur.myenglish.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.timur.myenglish.controller.TaskConroller;

/**
 * Created by timur on 25.02.17.
 */

public class tvUnit implements View.OnClickListener {
    Context context;

    public tvUnit (Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Intent intentUnit = new Intent(context, TaskConroller.class);
        context.startActivity(intentUnit);
    }
}
