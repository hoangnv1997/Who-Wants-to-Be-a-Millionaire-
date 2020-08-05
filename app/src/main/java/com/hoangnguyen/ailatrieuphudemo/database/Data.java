package com.hoangnguyen.ailatrieuphudemo.database;

import android.content.Context;
import android.util.Log;

import com.hoangnguyen.ailatrieuphudemo.model.Question;

import java.util.ArrayList;
import java.util.Random;

public class Data {
    private static ArrayList<ArrayList<Question>> arrQues;

    public Data(Context context) {
        getQuestionFromSQLite(context);
    }

    public void getQuestionFromSQLite(Context context) {
        DBManager db = new DBManager(context);
        db.open();
        arrQues = new ArrayList<>(db.getQuestions());
        db.close();
    }
    public static ArrayList<ArrayList<Question>> getArrQues(){
        return arrQues;
    }
    public Question createData(int level) {
        Random random = new Random();
        ArrayList<Question> arr = arrQues.get(14-level);
        Log.d("test", String.valueOf((14-level)));
        return arr.get(random.nextInt(arr.size()));
    }


}
