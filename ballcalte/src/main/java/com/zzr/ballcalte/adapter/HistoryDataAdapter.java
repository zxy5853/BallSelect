package com.zzr.ballcalte.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zzr.ballcalte.R;
import com.zzr.ballcalte.bean.BallsBean;

/**
 * 作者：zzr
 * 创建日期：2018/9/10
 * 描述：
 */
public class HistoryDataAdapter extends BaseQuickAdapter<BallsBean, BaseViewHolder> {

    public HistoryDataAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, BallsBean item) {
        if (item.getQihao() >= 100)
            helper.setText(R.id.tv_qihao, "第2018" + item.getQihao() + "期");
        else if (item.getQihao() < 100 && item.getQihao() >= 10)
            helper.setText(R.id.tv_qihao, "第20180" + item.getQihao() + "期");
        else if (item.getQihao() < 10)
            helper.setText(R.id.tv_qihao, "第201800" + item.getQihao() + "期");

        helper.setText(R.id.tv_red1, String.valueOf(item.getRed1()));
        helper.setText(R.id.tv_red2, String.valueOf(item.getRed2()));
        helper.setText(R.id.tv_red3, String.valueOf(item.getRed3()));
        helper.setText(R.id.tv_red4, String.valueOf(item.getRed4()));
        helper.setText(R.id.tv_red5, String.valueOf(item.getRed5()));
        helper.setText(R.id.tv_red6, String.valueOf(item.getRed6()));
        helper.setText(R.id.tv_blue, String.valueOf(item.getBlue()));
    }
}
