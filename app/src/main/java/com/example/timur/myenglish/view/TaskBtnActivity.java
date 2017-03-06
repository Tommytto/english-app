package com.example.timur.myenglish.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.timur.myenglish.R;
import com.example.timur.myenglish.listeners.AnswerListener;
import com.example.timur.myenglish.model.Word;

import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by timur on 18.02.17.
 *
 * Активити для заданий типа :
 * 1. Cлово - перевод
 * 2. Предложение с пропущенным словом
 * 3. Слово - значение
 */

public class TaskBtnActivity extends Activity {
    private static final int NOT_IDENTIFIED = -1;
    private static final int TASK_TRANSLATE = 1;
    private static final int TASK_FILL_GAPS = 2;
    private static final int TASK_MEANING = 3;

    private Button[] buttons = new Button[4];

    public Button[] getButtons() {
        return buttons;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task1_main);

        Intent intentParent = getIntent();
        int mode = intentParent.getIntExtra("mode", NOT_IDENTIFIED);

        //Получаем данные с контроллера
        ArrayList<Word> words = (ArrayList<Word>) intentParent.getExtras().getSerializable("words");
        Word word = (Word) intentParent.getExtras().getSerializable("word");
        Log.d(TAG, "HERE " + words);
        TextView taskDescription = (TextView) findViewById(R.id.tvTaskDecription);
        TextView taskText = (TextView) findViewById(R.id.tvSentence);

        buttons[0] = (Button) findViewById(R.id.btnChoose1);
        buttons[1] = (Button) findViewById(R.id.btnChoose2);
        buttons[2] = (Button) findViewById(R.id.btnChoose3);
        buttons[3] = (Button) findViewById(R.id.btnChoose4);

        Random rnd = new Random();

        int right = -1;
        switch (mode) {
            case TASK_TRANSLATE:
                for (int i = 0; i < 4; i++){
                    buttons[i].setText(words.get(i).getLang2());
                    if (words.get(i).equals(word)) {
                        right = i;
                    }
                    buttons[i].setOnClickListener(new AnswerListener(right, i, this));
                }
                taskDescription.setText("Choose right translate");
                taskText.setText(word.getLang1());
                break;

            case TASK_FILL_GAPS:
                for (int i = 0; i < 4; i++){
                    buttons[i].setText(words.get(i).getLang1());
                    if (words.get(i).equals(word)) {
                        right = i;
                    }
                    buttons[i].setOnClickListener(new AnswerListener(right, i, this));
                }
                if (!word.getSent2().equals("")){
                    int i = rnd.nextInt(2);
                    if (i == 0)
                        taskText.setText(word.getSent1().replace(word.getLang1(), "___"));
                    else
                        taskText.setText(word.getSent2().replace(word.getLang1(), "___"));
                } else {
                    taskText.setText(word.getSent1().replace(word.getLang1(), "___"));
                }
                taskDescription.setText("Fill words in the gaps");
                break;

            case TASK_MEANING:
                for (int i = 0; i < 4; i++){
                    buttons[i].setText(words.get(i).getLang1());
                    if (words.get(i).equals(word))
                        right = i;
                    buttons[i].setOnClickListener(new AnswerListener(right, i, this));
                }
                taskDescription.setText("Select the word in its meaning");
                taskText.setText(word.getDef1());
                break;
        }

    }
}
