package com.example.timur.myenglish.listeners;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.example.timur.myenglish.view.TaskWButActivity;

import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 25.02.17.
 */

public class UChooseListener implements View.OnClickListener {
    private Activity activity;
    private static final int TASK_TRANSLATE = 1;
    private static final int TASK_FILL_GAPS = 2;
    private static final int TASK_MEANING = 3;
    private static final int TASK_FIND_SYNONYM = 4;
    private static final int TASK_FIND_ANTONYM = 5;

    public UChooseListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "LISTENER");
        Random rand = new Random();

        int randomTask = rand.nextInt(3) + 1;
        Intent intent = null;
        switch (randomTask) {
            case TASK_TRANSLATE:
                intent = new Intent(activity, TaskWButActivity.class);
                intent.putExtra("mode", TASK_TRANSLATE);
                break;
            case TASK_FILL_GAPS:
                intent = new Intent(activity, TaskWButActivity.class);
                intent.putExtra("mode", TASK_FILL_GAPS);
                break;
            case TASK_MEANING:
                intent = new Intent(activity, TaskWButActivity.class);
                intent.putExtra("mode", TASK_MEANING);
                break;
            case TASK_FIND_SYNONYM:
                intent = new Intent(activity, TaskWButActivity.class);
                break;
            case TASK_FIND_ANTONYM:
                intent = new Intent(activity, TaskWButActivity.class);
                break;
        }
        activity.startActivity(intent);
    }
}
