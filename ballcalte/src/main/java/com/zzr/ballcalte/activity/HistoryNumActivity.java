package com.zzr.ballcalte.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zzr.ballcalte.R;
import com.zzr.ballcalte.adapter.HistoryDataAdapter;
import com.zzr.ballcalte.bean.BallResultBean;
import com.zzr.ballcalte.bean.BallsBean;
import com.zzr.ballcalte.utils.RealmHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：zzr
 * 创建日期：2018/9/10
 * 描述：
 */
public class HistoryNumActivity extends Activity {

    @BindView(R.id.rv_history)
    RecyclerView rvHistory;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private HistoryDataAdapter adapter;
    private List<BallsBean> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        initAdapter();
        initRefresh();
        getData();
    }

    private void getData() {
        List<BallsBean> dbList = RealmHelper.getInstance().findAll(BallsBean.class);
        if (dbList != null) {
            for (int i = dbList.size() - 1; i >= 0; i--) {
                list.add(dbList.get(i));
            }
        }

        if (refresh != null) {
            refresh.finishRefresh();
        }
        adapter.setNewData(list);
    }

    private void initRefresh() {
        refresh.setEnableLoadMore(false);
        refresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                if (list.size() > 0)
                    list.clear();
                getData();
            }
        });
    }

    private void initAdapter() {
        adapter = new HistoryDataAdapter(R.layout.item_history_balls);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        rvHistory.setAdapter(adapter);
    }

    public void addHistoryData(View view) {
        startActivity(new Intent(this, AddDataActivity.class));
    }

    public void getResult(View view) {
        List<BallResultBean> resultBeans = new ArrayList<>();
        for (BallsBean ballsBean : list) {
            resultBeans.add(creatBean(ballsBean, 0));
            resultBeans.add(creatBean(ballsBean, 1));
        }

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putParcelableArrayListExtra("resultBeans", (ArrayList<? extends Parcelable>) resultBeans);
        startActivity(intent);
    }

    private BallResultBean creatBean(BallsBean ballsBean, int type) {
        BallResultBean bean = new BallResultBean();
        bean.setQihao(ballsBean.getQihao());
        int r1 = ballsBean.getRed1();
        int r2 = ballsBean.getRed2();
        int r3 = ballsBean.getRed3();
        int r4 = ballsBean.getRed4();
        int r5 = ballsBean.getRed5();
        int r6 = ballsBean.getRed6();
        int b = ballsBean.getBlue();

        //2h*2-1h
        bean.setTen(r2 * 2 - r1);   //xuan
        bean.setOne(r6 * 2 - r5 - r4);    //sha hao
        bean.setTwo(r6 - r3);    //shahao
        bean.setThree(r6 - r1);    //shahao daiding
        bean.setFour(r2 + r4 -r1);    //shahao daiding
        bean.setFive(r2 + r4 -r1*2);    //shahao daiding
        bean.setSix(r6 - b);    //shahao daiding

        bean.setRed1(ballsBean.getRed1());
        bean.setRed2(ballsBean.getRed2());
        bean.setRed3(ballsBean.getRed3());
        bean.setRed4(ballsBean.getRed4());
        bean.setRed5(ballsBean.getRed5());
        bean.setRed6(ballsBean.getRed6());
        bean.setBlue(ballsBean.getBlue());

        bean.setItemType(type);
        return bean;
    }
}
