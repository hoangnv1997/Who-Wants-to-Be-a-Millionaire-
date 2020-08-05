package com.hoangnguyen.ailatrieuphudemo.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hoangnguyen.ailatrieuphudemo.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DBManager {
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private MyDBHelper mMyDBHelper;

    public DBManager(Context mContext) {
        this.mContext = mContext;
    }

    public DBManager open() {
        this.mMyDBHelper = new MyDBHelper(this.mContext);
        this.mDatabase = this.mMyDBHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        this.mMyDBHelper.close();
    }

    public ArrayList<ArrayList<Question>> getQuestions() {
        ArrayList<ArrayList<Question>> arr = new ArrayList<>();
        HashMap<Integer, ArrayList<Question>> arrs = new HashMap<>();
        Cursor cursor = this.mDatabase.query("Questions",
                new String[]{"level", "question", "correctanswer", "wronganswer"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int level = cursor.getInt(cursor.getColumnIndex("level"));
            ArrayList<Question> arrLevel = arrs.get(level);
            if (arrLevel == null) {
                arrLevel = new ArrayList<>();
            }
            arrLevel.add(createQuestion(
                    cursor.getString(cursor.getColumnIndex("question")),
                    cursor.getString(cursor.getColumnIndex("correctanswer")),
                    cursor.getString(cursor.getColumnIndex("wronganswer"))
            ));
            arrs.put(level, arrLevel);
        }
        TreeMap<Integer, ArrayList<Question>> sorted = new TreeMap<>(arrs);
        for (Integer key : sorted.keySet()) {
            arr.add(arrs.get(key));
        }
        return arr;
    }

    private Question createQuestion(String s1, String s2, String s3) {
        Question question = new Question();
        question.setmContentQues(s1);
        question.setmCorrectAns(s2);
        question.setmIncorrectAns(s3);
        return question;
    }
}
