package com.example.timur.myenglish.listeners;

import android.app.Activity;
import android.view.View;

import com.example.timur.myenglish.controllers.Configs;
import com.example.timur.myenglish.controllers.Info;

/**
 * Created by timur on 25.02.17.
 *
 * Обработчик выбора юнита
 */

public class UChooseListener implements View.OnClickListener {
    private Activity activity;
    private int unit;


    public UChooseListener(Activity activity, int unit) {
        this.unit = unit;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Info.setCurrentUnit(unit);
//        Configs.isFinished(unit, activity);
        Configs.hasProgress(activity);
    }
}
