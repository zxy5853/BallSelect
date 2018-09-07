package com.zzr.ballcalte.adapter;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zzr.ballcalte.R;
import com.zzr.ballcalte.bean.BallBean;

/**
 * 作者：zzr
 * 创建日期：2018/9/6
 * 描述：
 */
public class SelectAdapter extends BaseQuickAdapter<BallBean, BaseViewHolder> {
    public SelectAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, BallBean item) {
        helper.setText(R.id.tv_ball, String.valueOf(item.getNum()));
        if (item.getColor() == 1) {
            if (item.isSelect()) {
                helper.setBackgroundRes(R.id.tv_ball, R.drawable.red_circle);
                helper.setTextColor(R.id.tv_ball, Color.parseColor("#ffffff"));
            } else {
                helper.setBackgroundRes(R.id.tv_ball, R.drawable.white_circle);
                helper.setTextColor(R.id.tv_ball, Color.parseColor("#000000"));
            }
        } else if (item.getColor() == 2 && item.isSelect()) {
            if (item.isSelect()) {
                helper.setBackgroundRes(R.id.tv_ball, R.drawable.blue_circle);
                helper.setTextColor(R.id.tv_ball, Color.parseColor("#ffffff"));
            } else {
                helper.setBackgroundRes(R.id.tv_ball, R.drawable.white_circle);
                helper.setTextColor(R.id.tv_ball, Color.parseColor("#000000"));
            }
        }
    }
}
