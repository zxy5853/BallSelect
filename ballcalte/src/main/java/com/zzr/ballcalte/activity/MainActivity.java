package com.zzr.ballcalte.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.zzr.ballcalte.Constance;
import com.zzr.ballcalte.R;
import com.zzr.ballcalte.adapter.BallsAdapter;
import com.zzr.ballcalte.bean.BallBean;
import com.zzr.ballcalte.bean.BallsBean;
import com.zzr.ballcalte.utils.NewBeeToastUtils;
import com.zzr.ballcalte.widge.SelectDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_danSelect)
    TextView tvDanSelect;
    @BindView(R.id.tv_tuoSelect)
    TextView tvTuoSelect;
    @BindView(R.id.tv_blueSelect)
    TextView tvBlueSelect;
    @BindView(R.id.tv_totalNum)
    TextView tvTotalNum;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    private List<BallBean> selectDans = new ArrayList<>();
    private List<BallBean> selectTuos = new ArrayList<>();
    private List<BallBean> selectBlues = new ArrayList<>();

    private List<BallBean> allRedBall = new ArrayList<>();
    private List<BallBean> allBlueBall = new ArrayList<>();

    private SelectDialog dialog;
    private BallsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initAdapter();
    }

    private void initData() {
        initRedBall();

        for (int ball : Constance.blueBalls) {
            BallBean blueBall = new BallBean();
            blueBall.setColor(2);
            blueBall.setNum(ball);
            allBlueBall.add(blueBall);
        }
    }

    private void initRedBall() {
        if (allRedBall.size() > 0)
            allRedBall.clear();

        for (int redBall : Constance.redBalls) {
            BallBean redBean = new BallBean();
            redBean.setColor(1);
            redBean.setNum(redBall);
            allRedBall.add(redBean);
        }
    }

    private void initAdapter() {
        adapter = new BallsAdapter(R.layout.item_balls);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(adapter);
    }

    private void showDialog(int type, List<BallBean> list) {
        dialog = new SelectDialog(this, list, type);
        dialog.builder()
                .setOnCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).setOnSureClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String danNum = "";
                if (dialog.getType() == 0) {
                    for (BallBean ballBean : dialog.getList()) {
                        if (ballBean.isSelect()) {
                            selectDans.add(ballBean);
                            danNum += ballBean.getNum() + ",";
                        }
                    }
                    if (!TextUtils.isEmpty(danNum)) {
                        danNum = danNum.substring(0, danNum.length() - 1);
                        tvDanSelect.setText(danNum);
                    }
                    dialog.dismiss();
                } else if (dialog.getType() == 1) {
                    for (BallBean ballBean : dialog.getList()) {
                        if (ballBean.isSelect()) {
                            selectTuos.add(ballBean);
                            danNum += ballBean.getNum() + ",";
                        }
                    }
                    if (!TextUtils.isEmpty(danNum)) {
                        danNum = danNum.substring(0, danNum.length() - 1);
                        tvTuoSelect.setText(danNum);
                    }
                    if (selectTuos.size() < 3) {
                        NewBeeToastUtils.showToastLong(MainActivity.this, "请选择三个以上的红球作为拖码！");
                        return;
                    } else {
                        dialog.dismiss();
                    }
                } else if (dialog.getType() == 2) {
                    for (BallBean ballBean : dialog.getList()) {
                        if (ballBean.isSelect()) {
                            selectBlues.add(ballBean);
                            danNum += ballBean.getNum() + ",";
                        }
                    }
                    if (!TextUtils.isEmpty(danNum)) {
                        danNum = danNum.substring(0, danNum.length() - 1);
                        tvBlueSelect.setText(danNum);
                    }
                    dialog.dismiss();
                }
            }
        }).show();
    }

    @OnClick({R.id.tv_danSelect, R.id.tv_tuoSelect, R.id.tv_blueSelect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_danSelect:
                initRedBall();
                showDialog(0, allRedBall);
                break;
            case R.id.tv_tuoSelect:
                if (selectDans.size() == 0) {
                    NewBeeToastUtils.showToastLong(this, "请先选择胆码！");
                    return;
                } else if (selectDans.size() > 0) {
                    handleData();
                }
                showDialog(1, allRedBall);
                break;
            case R.id.tv_blueSelect:
                showDialog(2, allBlueBall);
                break;
        }
    }

    private void handleData() {
        for (BallBean selectDan : selectDans) {
            allRedBall.remove(selectDan);
        }
    }

    public void getNumbs(View view) {
        if (selectDans.size() == 0) {
            NewBeeToastUtils.showToastLong(this, "请选择胆码！");
            return;
        }

        if (selectTuos.size() == 0) {
            NewBeeToastUtils.showToastLong(this, "请选择拖码！");
            return;
        }

        if (selectBlues.size() == 0) {
            NewBeeToastUtils.showToastLong(this, "请选择蓝球！");
            return;
        }

        int danNum = selectDans.size();
        int tuoNum = selectTuos.size();
        int blueNum = selectBlues.size();
        int totalNum = getTotalNum(danNum, tuoNum, blueNum);
        tvTotalNum.setText("本次共选择" + totalNum + "注");
    }

    private int getTotalNum(int danNum, int tuoNum, int blueNum) {
        int totalNum = 0;
        int needTuoNum = 6 - danNum;                //需要拖码的个数
        int needProduct = tuoNum - needTuoNum;  //需要乘积的次数
        int temp = 1;

        for (int i = 0; i < needProduct; i++) {
            temp = temp * tuoNum;
            tuoNum--;
        }
        totalNum = temp * blueNum;
        return totalNum;
    }

    private void getBalls() {
        int danNum = selectDans.size();
        int tuoNum = selectTuos.size();
        int blueNum = selectBlues.size();
        List<BallsBean> list = new ArrayList<>();
        BallsBean ballsBean = new BallsBean();

        for (BallBean selectDan : selectDans) {

        }
    }
}
