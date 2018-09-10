package com.zzr.ballcalte.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zzr.ballcalte.R;
import com.zzr.ballcalte.adapter.HistoryDataAdapter;
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
    private int pageNum = 1;
    private List<BallsBean> list = new ArrayList<>();

    private RealmHelper<BallsBean> realmHelper;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                adapter.setNewData(list);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        realmHelper = new RealmHelper<BallsBean>();
        initAdapter();

        getData();
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (realmHelper.findByPage(BallsBean.class, pageNum, null) != null)
                    list.addAll(realmHelper.findByPage(BallsBean.class, pageNum, null));

                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);

                if (refresh != null) {
                    if (pageNum > 1)
                        refresh.finishLoadMore();
                    else
                        refresh.finishRefresh();
                }
            }
        }).start();
    }

    private void initRefresh() {
        refresh.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                pageNum++;
                getData();
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                pageNum = 1;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realmHelper.close();
        handler.removeMessages(1);
    }
}
