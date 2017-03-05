package com.example.timur.myenglish.listeners;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.timur.myenglish.controllers.TaskController;
import com.example.timur.myenglish.view.TaskBtnActivity;

import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 25.02.17.
 *
 * Обработчик выбора юнита
 */

public class UChooseListener implements View.OnClickListener {
    private Activity activity;


    public UChooseListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {

        //todo по нажатию передать контроллеру id юнита
        Intent taskIntent = new Intent (activity, TaskController.class);
        activity.startActivity(taskIntent);
    }
}
