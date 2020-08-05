package com.hoangnguyen.ailatrieuphudemo.model;

public class Bounty {
    private String mNumberQues;
    private String mBounty;

    public Bounty(String mNumberQues, String mBounty) {
        this.mNumberQues = mNumberQues;
        this.mBounty = mBounty;
    }

    public String getmNumberQues() {
        return mNumberQues;
    }

    public void setmNumberQues(String mNumberQues) {
        this.mNumberQues = mNumberQues;
    }

    public String getmBounty() {
        return mBounty;
    }

    public void setmBounty(String mBounty) {
        this.mBounty = mBounty;
    }
}
