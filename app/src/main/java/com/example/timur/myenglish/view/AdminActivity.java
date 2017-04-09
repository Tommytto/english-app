package com.example.timur.myenglish.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.timur.myenglish.R;

import java.util.List;

/**
 * Created by timur on 05.03.17.
 */

public class AdminActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.admin_main);
        String [] names = {"hello", "good", "yeah"};

        ListView studentsList = (ListView)findViewById(R.id.students_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, names);

        // присваиваем адаптер списку
        studentsList.setAdapter(adapter);
    }
}
