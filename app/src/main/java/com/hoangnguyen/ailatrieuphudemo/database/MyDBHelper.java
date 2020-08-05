package com.hoangnguyen.ailatrieuphudemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "data1.sqlite";
    private static final int DB_VERSION = 1;
    private String mQuery = "CREATE TABLE" + " Questions"
            + "("
            + "id" + " INTEGER" + " PRIMARY KEY" + " autoincrement,"
            + "level" + " INTEGER,"
            + "question" + " TEXT,"
            + "correctanswer" + " TEXT,"
            + "wronganswer" + " TEXT"
            + ")";


    public MyDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(mQuery);
        insertData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void insertData(SQLiteDatabase db) {
        String ROW1 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('1', 'question1', 'answer1', 'wrong1&wrong2&wrong3')";
        String ROW2 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('2', 'question2', 'answer2', 'wrong1&wrong2&wrong3')";
        String ROW3 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('3', 'question3', 'answer3', 'wrong1&wrong2&wrong3')";
        String ROW4 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('4', 'question4', 'answer4', 'wrong1&wrong2&wrong3')";
        String ROW5 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('5', 'question5', 'answer5', 'wrong1&wrong2&wrong3')";
        String ROW6 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('6', 'question6', 'answer6', 'wrong1&wrong2&wrong3')";
        String ROW7 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('7', 'question7', 'answer7', 'wrong1&wrong2&wrong3')";
        String ROW8 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('8', 'question8', 'answer8', 'wrong1&wrong2&wrong3')";
        String ROW9 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('9', 'question9', 'answer9', 'wrong1&wrong2&wrong3')";
        String ROW10 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('10', 'question10', 'answer10', 'wrong1&wrong2&wrong3')";
        String ROW11 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('11', 'question11', 'answer11', 'wrong1&wrong2&wrong3')";
        String ROW12 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('12', 'question12', 'answer12', 'wrong1&wrong2&wrong3')";
        String ROW13 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('13', 'question13', 'answer13', 'wrong1&wrong2&wrong3')";
        String ROW14 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('14', 'question14', 'answer14', 'wrong1&wrong2&wrong3')";
        String ROW15 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('15', 'question15', 'answer15', 'wrong1&wrong2&wrong3')";
        String ROW16 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('1', 'question16', 'answer16', 'wrong1&wrong2&wrong3')";
        String ROW17= "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('1', 'question17', 'answer17', 'wrong1&wrong2&wrong3')";
        String ROW18= "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('2', 'question18', 'answer18', 'wrong1&wrong2&wrong3')";
        String ROW19 = "INSERT INTO " + "Questions" + " (" + "level" + ", " + "question" + ", " + "correctanswer" + ", " + "wronganswer" + ") Values ('2', 'question19', 'answer19', 'wrong1&wrong2&wrong3')";
        db.execSQL(ROW1);db.execSQL(ROW2);db.execSQL(ROW3);db.execSQL(ROW4);db.execSQL(ROW5);db.execSQL(ROW6);
        db.execSQL(ROW7);db.execSQL(ROW8);db.execSQL(ROW9);db.execSQL(ROW10);db.execSQL(ROW11);db.execSQL(ROW12);
        db.execSQL(ROW13);db.execSQL(ROW14);db.execSQL(ROW15);db.execSQL(ROW16);db.execSQL(ROW17);db.execSQL(ROW18);
        db.execSQL(ROW19);
    }
}
