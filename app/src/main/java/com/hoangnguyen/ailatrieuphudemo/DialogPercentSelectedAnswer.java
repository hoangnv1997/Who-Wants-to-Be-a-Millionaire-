package com.hoangnguyen.ailatrieuphudemo;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.DialogCompat;

import java.util.Random;

public class DialogPercentSelectedAnswer extends Dialog {
    private TextView mTvAnswerA, mTvAnswerB, mTvAnswerC, mTvAnswerD;

    public DialogPercentSelectedAnswer(@NonNull Context context, int positionCorrectAns) {
        super(context);
        setContentView(R.layout.dialog_ask_the_audience);
        mTvAnswerA = findViewById(R.id.tv_percent_answer_a);
        mTvAnswerB = findViewById(R.id.tv_percent_answer_b);
        mTvAnswerC = findViewById(R.id.tv_percent_answer_c);
        mTvAnswerD = findViewById(R.id.tv_percent_answer_d);

        int arrRandom[] = new int[]{0, 0, 0, 0};
        int distance = 25;
        for (int i = 0; i < arrRandom.length; i++) {
            arrRandom[i] = arrRandom[i] + distance;
            if (i == positionCorrectAns - 1) {
                arrRandom[i] = arrRandom[i] + 25;
                distance = distance + 25;
            }
            distance = distance + 25;
        }

        int total = 125;
        int arrPercentAnswer[] = new int[]{0, 0, 0, 0}; // a b c d
        int totalAudience = 100;
        Random random = new Random();
        for (int i = 0; i < totalAudience; i++) {
            int r = random.nextInt(total);
            if (r >= 0 && r < arrRandom[0]) {
                arrPercentAnswer[0]++;
            } else if (r >= arrRandom[0] && r < arrRandom[1]) {
                arrPercentAnswer[1]++;
            } else if (r >= arrRandom[1] && r < arrRandom[2]) {
                arrPercentAnswer[2]++;
            } else {
                arrPercentAnswer[3]++;
            }
        }

        mTvAnswerA.setText("A: " + arrPercentAnswer[0] * 100.0f / totalAudience + " %");
        mTvAnswerB.setText("B: " + arrPercentAnswer[1] * 100.0f / totalAudience + " %");
        mTvAnswerC.setText("C: " + arrPercentAnswer[2] * 100.0f / totalAudience + " %");
        mTvAnswerD.setText("D: " + arrPercentAnswer[3] * 100.0f / totalAudience + " %");
    }
}
