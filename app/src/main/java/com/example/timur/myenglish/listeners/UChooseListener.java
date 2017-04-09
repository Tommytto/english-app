package com.example.timur.myenglish.listeners;

import android.app.Activity;
import android.icu.util.Calendar;
import android.view.View;
import android.widget.Toast;

import com.example.timur.myenglish.controllers.Configs;
import com.example.timur.myenglish.controllers.Constants;
import com.example.timur.myenglish.controllers.Info;

import static com.example.timur.myenglish.model.CashLoader.isEndedDailyLimit;
import static com.example.timur.myenglish.model.CashLoader.loadDailyLimit;

/**
 * Created by timur on 25.02.17.
 * <p>
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
        Calendar calendar = Calendar.getInstance();
        isEndedDailyLimit(Constants.Cash.TASKS_DAILY_LIMIT_CASH, calendar.getTimeInMillis(), activity);

        if (loadDailyLimit(Constants.Cash.TASKS_DAILY_LIMIT_CASH, activity) >= 9) {
            Toast toast = Toast.makeText(activity, "Sorry, come in tomorrow!", Toast.LENGTH_LONG);
            if (!toast.getView().isShown()) {
                toast.show();
            }
        } else {
            Info.setCurrentUnit(unit);
//        Configs.isFinished(unit, activity);
            Configs.hasProgress(activity);
        }
    }
}
