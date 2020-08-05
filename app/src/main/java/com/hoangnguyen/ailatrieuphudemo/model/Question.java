package com.hoangnguyen.ailatrieuphudemo.model;

import java.util.ArrayList;

public class Question {
    private String mContentQues;
    private String mCorrectAns;
    private ArrayList mIncorrectAns;

    public Question() {
    }

    public Question(String mContentQues, String mCorrectAns, ArrayList mIncorrectAns) {
        this.mContentQues = mContentQues;
        this.mCorrectAns = mCorrectAns;
        this.mIncorrectAns = mIncorrectAns;
    }

    public String getmContentQues() {
        return mContentQues;
    }

    public void setmContentQues(String mContentAns) {
        this.mContentQues = mContentAns;
    }

    public String getmCorrectAns() {
        return mCorrectAns;
    }

    public void setmCorrectAns(String mCorrectAns) {
        this.mCorrectAns = mCorrectAns;
    }

    public ArrayList getmIncorrectAns() {
        return mIncorrectAns;
    }

    public void setmIncorrectAns(ArrayList mIncorrectAns) {
        this.mIncorrectAns = mIncorrectAns;
    }

    public void setmIncorrectAns(String mIncorrectAns1) {
        String[] strings = mIncorrectAns1.split("&");
        this.mIncorrectAns = new ArrayList();
        for (String s : strings) {
            mIncorrectAns.add(s);
        }
    }
}
