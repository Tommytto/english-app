package com.example.timur.myenglish.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.listeners.tvUnit;
import com.example.timur.myenglish.model.Unit_1;
import com.example.timur.myenglish.view.TaskActivity_1;
import com.example.timur.myenglish.view.TaskActivity_2;

import java.util.Random;

/**
 * Created by timur on 25.02.17.
 */

public class TaskConroller extends Activity {

    private static final int TASK_TRANSLATE = 1;
    private static final int TASK_FILL_GAPS = 2;
    private static final int TASK_FIND_SYNONYM = 3;
    private static final int TASK_FIND_ANTONYM = 4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Random rand = new Random();

        int randomTask = rand.nextInt(4) + 1;
        Unit_1 unitModel = new Unit_1(this);

        switch (randomTask) {
            case TASK_TRANSLATE:
                Intent intentTask1 = new Intent(this, TaskActivity_2.class);
                intentTask1.putExtra("word", "hello");
                break;
            case TASK_FILL_GAPS:
                Intent intentTask2 = new Intent(this, TaskActivity_2.class);
                break;
            default:
                Intent intentTask3 = new Intent(this, TaskActivity_2.class);
                break;
        }

    }
}
