package com.example.timur.myenglish.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.listeners.UChooseListener;
import com.example.timur.myenglish.model.api.FindProgressModel;

/**
 * Created by timur on 25.02.17.
 */

public class UnitsActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.units_main);

        TextView tvUnit = (TextView) findViewById(R.id.tvUnit);

        tvUnit.setOnClickListener(new UChooseListener(this, 1));
        FindProgressModel model = new FindProgressModel();
    }
}
