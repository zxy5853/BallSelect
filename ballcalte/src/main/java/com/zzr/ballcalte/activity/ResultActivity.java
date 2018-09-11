package com.zzr.ballcalte.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zzr.ballcalte.R;
import com.zzr.ballcalte.adapter.ResultAdapter;
import com.zzr.ballcalte.bean.BallResultBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：zzr
 * 创建日期：2018/9/11
 * 描述：
 */
public class ResultActivity extends Activity {
    @BindView(R.id.rv_history)
    RecyclerView rvHistory;

    private ResultAdapter resultAdapter;
    private List<BallResultBean> resultBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        resultBeans = intent.getParcelableArrayListExtra("resultBeans");
        initAdapter();
    }

    private void initAdapter() {
        if (resultBeans != null)
            resultAdapter = new ResultAdapter(resultBeans);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        rvHistory.setAdapter(resultAdapter);
    }
}
