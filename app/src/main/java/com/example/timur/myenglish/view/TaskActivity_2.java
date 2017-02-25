package com.example.timur.myenglish.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.listeners.btnChoose_Task2;
import com.example.timur.myenglish.model.Unit_1;

import java.util.ArrayList;

/**
 * Created by timur on 18.02.17.
 */

public class TaskActivity_2 extends Activity {

    private String taskText = "Hello my name ... Timur!";
    private String [] answers = {"are" , "here", "is", "so good"};
    private String rightAnswer = "is";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task2_main);

        Unit_1 unitModel = new Unit_1(this);
        Intent intentParent = getIntent();

        TextView textTask = (TextView) findViewById(R.id.tvTaskDecription);

        Button btnChoose1 = (Button) findViewById(R.id.btnChoose1);
        Button btnChoose2 = (Button) findViewById(R.id.btnChoose2);
        Button btnChoose3 = (Button) findViewById(R.id.btnChoose3);
        Button btnChoose4 = (Button) findViewById(R.id.btnChoose4);

        btnChoose1.setText(answers[0]);
        btnChoose2.setText(answers[1]);
        btnChoose3.setText(answers[2]);
        btnChoose4.setText(answers[3]);

        btnChoose1.setOnClickListener(new btnChoose_Task2());
        btnChoose2.setOnClickListener(new btnChoose_Task2());
        btnChoose3.setOnClickListener(new btnChoose_Task2());
        btnChoose4.setOnClickListener(new btnChoose_Task2());

        textTask.setText(intentParent.getStringExtra("word"));

    }

    public boolean isRightAnswer (String answer) {
        return answer.equals(rightAnswer);
    }
}
