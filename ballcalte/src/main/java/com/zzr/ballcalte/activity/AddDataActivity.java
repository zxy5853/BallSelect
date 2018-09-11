package com.zzr.ballcalte.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.zzr.ballcalte.R;
import com.zzr.ballcalte.bean.BallsBean;
import com.zzr.ballcalte.utils.NewBeeToastUtils;
import com.zzr.ballcalte.utils.RealmHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：zzr
 * 创建日期：2018/9/10
 * 描述：
 */
public class AddDataActivity extends Activity {

    @BindView(R.id.et_qihao)
    EditText etQihao;
    @BindView(R.id.et_red1)
    EditText etRed1;
    @BindView(R.id.et_red2)
    EditText etRed2;
    @BindView(R.id.et_red3)
    EditText etRed3;
    @BindView(R.id.et_red4)
    EditText etRed4;
    @BindView(R.id.et_red5)
    EditText etRed5;
    @BindView(R.id.et_red6)
    EditText etRed6;
    @BindView(R.id.et_blue)
    EditText etBlue;

//    private RealmHelper realmHelper;
    private BallsBean ballsBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

//        realmHelper = new RealmHelper<>();
    }

    public void addNum(View view) {
        ballsBean = new BallsBean();
        ballsBean.setBlue(Integer.valueOf(etBlue.getText().toString()));
        ballsBean.setRed1(Integer.valueOf(etRed1.getText().toString()));
        ballsBean.setRed2(Integer.valueOf(etRed2.getText().toString()));
        ballsBean.setRed3(Integer.valueOf(etRed3.getText().toString()));
        ballsBean.setRed4(Integer.valueOf(etRed4.getText().toString()));
        ballsBean.setRed5(Integer.valueOf(etRed5.getText().toString()));
        ballsBean.setRed6(Integer.valueOf(etRed6.getText().toString()));
        ballsBean.setQihao(etQihao.getText().toString());
        RealmHelper.getInstance().copyObj2Realm(ballsBean);

        NewBeeToastUtils.showToastLong(this, "添加成功！");
        etRed1.getText().clear();
        etRed2.getText().clear();
        etRed3.getText().clear();
        etRed4.getText().clear();
        etRed5.getText().clear();
        etRed6.getText().clear();
        etBlue.getText().clear();
        etQihao.getText().clear();
    }
}
