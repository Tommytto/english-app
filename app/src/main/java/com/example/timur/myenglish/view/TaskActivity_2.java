package com.example.timur.myenglish.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.model.SQueryFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 18.02.17.
 */

public class TaskActivity_2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task2_main);

        Log.d(TAG, "TASKACTIVITY");

        SQueryFactory unitModel = new SQueryFactory(this);
        Log.d(TAG, unitModel.getWord().getLang1());
        Intent intentParent = getIntent();

        TextView textTask = (TextView) findViewById(R.id.tvTaskDecription);

        Button[] buttons = new Button[4];

        buttons[0] = (Button) findViewById(R.id.btnChoose1);
        buttons[1] = (Button) findViewById(R.id.btnChoose2);
        buttons[2] = (Button) findViewById(R.id.btnChoose3);
        buttons[3] = (Button) findViewById(R.id.btnChoose4);

        textTask.setText(intentParent.getStringExtra("word"));

    }
}
