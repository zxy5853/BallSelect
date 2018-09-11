package com.zzr.ballcalte.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zzr.ballcalte.R;
import com.zzr.ballcalte.bean.BallResultBean;

import java.util.List;

/**
 * 作者：zzr
 * 创建日期：2018/9/10
 * 描述：
 */
public class ResultAdapter extends BaseMultiItemQuickAdapter<BallResultBean, BaseViewHolder> {

    public ResultAdapter(@Nullable List<BallResultBean> data) {
        super(data);
        addItemType(0, R.layout.item_result_balls);
        addItemType(1, R.layout.item_history_balls);
    }

    @Override
    protected void convert(BaseViewHolder helper, BallResultBean item) {
        switch (item.getItemType()) {
            case 0:
                if (item.getQihao() >= 100)
                    helper.setText(R.id.tv_qihao, "第2018" + item.getQihao() + "期");
                else if (item.getQihao() < 100 && item.getQihao() >= 10)
                    helper.setText(R.id.tv_qihao, "第20180" + item.getQihao() + "期");
                else if (item.getQihao() < 10)
                    helper.setText(R.id.tv_qihao, "第201800" + item.getQihao() + "期");

                helper.setText(R.id.tv_redHe, String.valueOf(item.getRedHe()));
                helper.setText(R.id.tv_allHe, String.valueOf(item.getAllHe()));
                helper.setText(R.id.tv_redPingJun, String.valueOf(item.getRedPingJun()));
                helper.setText(R.id.tv_allPingJun, String.valueOf(item.getAllPingJun()));
                break;
            case 1:
//                if (item.getQihao() >= 100)
//                    helper.setText(R.id.tv_qihao, "第2018" + item.getQihao() + "期");
//                else if (item.getQihao() < 100 && item.getQihao() >= 10)
//                    helper.setText(R.id.tv_qihao, "第20180" + item.getQihao() + "期");
//                else if (item.getQihao() < 10)
//                    helper.setText(R.id.tv_qihao, "第201800" + item.getQihao() + "期");
                helper.setVisible(R.id.tv_qihao, false);
                helper.setText(R.id.tv_red1, String.valueOf(item.getRed1()));
                helper.setText(R.id.tv_red2, String.valueOf(item.getRed2()));
                helper.setText(R.id.tv_red3, String.valueOf(item.getRed3()));
                helper.setText(R.id.tv_red4, String.valueOf(item.getRed4()));
                helper.setText(R.id.tv_red5, String.valueOf(item.getRed5()));
                helper.setText(R.id.tv_red6, String.valueOf(item.getRed6()));
                helper.setText(R.id.tv_blue, String.valueOf(item.getBlue()));
                break;
        }
    }
}
