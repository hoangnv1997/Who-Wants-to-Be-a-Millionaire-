package com.hoangnguyen.ailatrieuphudemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hoangnguyen.ailatrieuphudemo.DialogPercentSelectedAnswer;
import com.hoangnguyen.ailatrieuphudemo.R;
import com.hoangnguyen.ailatrieuphudemo.adapter.BountyAdapter;
import com.hoangnguyen.ailatrieuphudemo.database.Data;
import com.hoangnguyen.ailatrieuphudemo.model.Bounty;
import com.hoangnguyen.ailatrieuphudemo.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    private ListView mListviewBounty;
    private ArrayList<Bounty> mArrBounty;
    private BountyAdapter mBountyAdapter;
    private TextView mTvQuestion, mTvAnswer1, mTvAnswer2, mTvAnswer3, mTvAnswer4, mTvEndGame;
    private ImageView mImgSupport5050, mImgPhoneAFriend, mImgAskAudience, mImgAskConsulting;
    private ArrayList<String> mArrAnswer;
    private Question mQuestion;
    private int mCurrentQues = 14;
    private ArrayList<TextView> mArrTvAnswer;
    private boolean mSupport5050 = true;
    private boolean mSupportByAudience = true;
    private View.OnClickListener mListener;
    private Data mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        init();
        mTvEndGame.setVisibility(View.INVISIBLE);
        showQuesAndAns();
        setClick();
    }

    public void setClick() {
        mListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer((TextView) v);
            }
        };
        for (TextView textView : mArrTvAnswer) {
            textView.setOnClickListener(mListener);
        }
    }

    public void checkAnswer(TextView result) {
        final String answer = result.getText().toString();
        result.setBackgroundResource(R.drawable.selected_answer_background);
        if (mSupport5050 == false) {
            mImgSupport5050.setVisibility(View.INVISIBLE);
        }
        if (mSupportByAudience == false) {
            mImgAskAudience.setVisibility(View.INVISIBLE);
        }
        // delay sau khi chon dap an
        new CountDownTimer(2000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                for (TextView textView : mArrTvAnswer) {
                    String s = textView.getText().toString();
                    if (s.equals(mQuestion.getmCorrectAns())) {
                        textView.setBackgroundResource(R.drawable.correct_answer_background);
                        break;
                    }
                }
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        if (answer.equals(mQuestion.getmCorrectAns())) {
                            mCurrentQues--;
                            showQuesAndAns();
                        } else {
                            mTvEndGame.setVisibility(View.VISIBLE);
                            if (mCurrentQues > 10 && mCurrentQues < 14) {
                                mTvEndGame.setText("Bạn sẽ ra về với số tiền thưởng là \n" + mArrBounty.get(mCurrentQues + 1).getmBounty() + " 000 VND");
                            } else if (mCurrentQues > 5 && mCurrentQues <= 9) {
                                mTvEndGame.setText("Bạn sẽ ra về với số tiền thưởng là 2.000.000 VND");
                            } else if (mCurrentQues < 5) {
                                mTvEndGame.setText("Bạn sẽ ra về với số tiền thưởng là \n" + mArrBounty.get(mCurrentQues + 1).getmBounty() + " 000 VND");
                            } else if (mCurrentQues == 14) {
                                mTvEndGame.setText("Bạn sẽ ra về với số tiền thưởng là 0 VND");
                            }
                            //Toast.makeText(PlayActivity.this, "You lose", Toast.LENGTH_SHORT).show();
                        }
                    }
                }.start();
            }
        }.start();


    }

    public void showQuesAndAns() {
        mQuestion = mData.createData(mCurrentQues);
        mTvQuestion.setText(mQuestion.getmContentQues());
        ArrayList<String> arrAnswer = new ArrayList<>(mQuestion.getmIncorrectAns());
        arrAnswer.add(mQuestion.getmCorrectAns());
        Collections.shuffle(arrAnswer);
        // set Text cho 4 dap an
        for (int i = 0; i < mArrTvAnswer.size(); i++) {
            mArrTvAnswer.get(i).setBackgroundResource(R.drawable.button_background);
            mArrTvAnswer.get(i).setText(arrAnswer.get(i));
        }
        // cap nhat xem dang o cau hoi so may
        mBountyAdapter.updatePositionQues(mCurrentQues);
    }

    public void init() {
        mListviewBounty = findViewById(R.id.lv_bounty);
        mTvQuestion = findViewById(R.id.tv_question);
        mTvAnswer1 = findViewById(R.id.tv_answer1);
        mTvAnswer2 = findViewById(R.id.tv_answer2);
        mTvAnswer3 = findViewById(R.id.tv_answer3);
        mTvAnswer4 = findViewById(R.id.tv_answer4);
        mTvEndGame = findViewById(R.id.tv_end_game);
        mImgSupport5050 = findViewById(R.id.img_support_50_50);
        mImgPhoneAFriend = findViewById(R.id.img_phone_a_friend);
        mImgAskAudience = findViewById(R.id.img_ask_the_audience);
        mImgAskConsulting = findViewById(R.id.img_ask_the_consulting);
        mArrBounty = new ArrayList<>();
        mArrTvAnswer = new ArrayList<>();
        mArrTvAnswer.add(mTvAnswer1);
        mArrTvAnswer.add(mTvAnswer2);
        mArrTvAnswer.add(mTvAnswer3);
        mArrTvAnswer.add(mTvAnswer4);
        mArrBounty.add(new Bounty("15", "150.000"));
        mArrBounty.add(new Bounty("14", "85.000"));
        mArrBounty.add(new Bounty("13", "60.000"));
        mArrBounty.add(new Bounty("12", "40.000"));
        mArrBounty.add(new Bounty("11", "30.000"));
        mArrBounty.add(new Bounty("10", "22.000"));
        mArrBounty.add(new Bounty("9", "14.000"));
        mArrBounty.add(new Bounty("8", "10.000"));
        mArrBounty.add(new Bounty("7", "6.000"));
        mArrBounty.add(new Bounty("6", "3.000"));
        mArrBounty.add(new Bounty("5", "2.000"));
        mArrBounty.add(new Bounty("4", "1.000"));
        mArrBounty.add(new Bounty("3", "600"));
        mArrBounty.add(new Bounty("2", "400"));
        mArrBounty.add(new Bounty("1", "200"));
        mBountyAdapter = new BountyAdapter(this, mArrBounty, mCurrentQues);
        mListviewBounty.setAdapter(mBountyAdapter);
//        ArrayList<String> arrIncorrectAns = new ArrayList<>();
//        arrIncorrectAns.add("Chelsea");
//        arrIncorrectAns.add("Manchester City");
//        arrIncorrectAns.add("Leicester City");
//        mQuestion = new Question("Which team won the Premier League in 2020?", "Liverpool", arrIncorrectAns);
//        mArrAnswer = new ArrayList<>(mQuestion.getmIncorrectAns());
//        mArrAnswer.add("Liverpool");
        mData = new Data(this);

    }

    // tro giup 50 50
    public void help5050(View view) {
        if (mSupport5050 == false) {
            return;
        }
        Random random = new Random();
        int numberHideAns = 2;
        do {
            int positionHideAns = random.nextInt(4);
            TextView textView = mArrTvAnswer.get(positionHideAns);
            if (textView.getVisibility() == View.VISIBLE && textView.getText().toString().equals(mQuestion.getmCorrectAns()) == false) {
                textView.setText("");
                textView.setOnClickListener(null);
                numberHideAns--;
            }
        } while (numberHideAns > 0);
        mSupport5050 = false;
    }

    // support by Audience
    public void supportByAudience(View view) {
        if (mSupportByAudience == false) {
            return;
        }
        for (int i = 0; i < mArrTvAnswer.size(); i++) {
            TextView textView = mArrTvAnswer.get(i);
            if (textView.getText().toString().equals(mQuestion.getmCorrectAns())) {
                new DialogPercentSelectedAnswer(this, i + 1).show();
                break;
            }
        }
        mSupportByAudience = false;
    }
}