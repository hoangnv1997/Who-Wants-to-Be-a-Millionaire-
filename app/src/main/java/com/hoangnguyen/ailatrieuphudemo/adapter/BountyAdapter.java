package com.hoangnguyen.ailatrieuphudemo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hoangnguyen.ailatrieuphudemo.R;
import com.hoangnguyen.ailatrieuphudemo.model.Bounty;

import java.util.ArrayList;

public class BountyAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Bounty> mArrBounty;
    private int mPositionQues;

    public BountyAdapter(Context mContext, ArrayList<Bounty> mArrBounty, int mPositionQues) {
        this.mContext = mContext;
        this.mArrBounty = mArrBounty;
        this.mPositionQues = mPositionQues;
    }

    public void updatePositionQues(int mPositionQues) {
        this.mPositionQues = mPositionQues;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mArrBounty.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrBounty.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        private TextView mTxtNumQues;
        private TextView mTxtBounty;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_bounty, null);
            viewHolder = new ViewHolder();
            viewHolder.mTxtNumQues = convertView.findViewById(R.id.txt_num_ques);
            viewHolder.mTxtBounty = convertView.findViewById(R.id.txt_bounty);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Bounty bounty = (Bounty) getItem(position);
        if (position % 5 == 0) {
            viewHolder.mTxtNumQues.setTextColor(Color.parseColor("#ffffff"));
            viewHolder.mTxtBounty.setTextColor(Color.parseColor("#ffffff"));
        }
        if (position == mPositionQues) {
            if (position%5==0){
                viewHolder.mTxtNumQues.setTextColor(Color.parseColor("#FFC107"));
                viewHolder.mTxtBounty.setTextColor(Color.parseColor("#FFC107"));
            }
            viewHolder.mTxtBounty.setBackgroundColor(Color.parseColor("#ffffff"));
            viewHolder.mTxtNumQues.setBackgroundColor(Color.parseColor("#ffffff"));
        }else {
            viewHolder.mTxtBounty.setBackgroundColor(Color.parseColor("#3F51B5"));
            viewHolder.mTxtNumQues.setBackgroundColor(Color.parseColor("#3F51B5"));
        }
        viewHolder.mTxtNumQues.setText(bounty.getmNumberQues());
        viewHolder.mTxtBounty.setText(bounty.getmBounty());
        return convertView;
    }
}
