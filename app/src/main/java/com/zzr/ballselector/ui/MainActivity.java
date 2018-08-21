package com.zzr.ballselector.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zzr.ballselector.R;
import com.zzr.ballselector.bean.UserBean;
import com.zzr.ballselector.databinding.ActivityMainBinding;
import com.zzr.ballselector.utils.NewBeeToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
    }

    private void initData() {
        UserBean userBean = new UserBean("zhangsan", 20);

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello1");

        Map<String, Object> map = new HashMap<>();
        map.put("key0", "ooook");
        map.put("key1", "ooookkkkk");

        String[] strs = {"aaaa", "bbbb"};

        mainBinding.setUserBean(userBean);
        mainBinding.setList(list);
        mainBinding.setMap(map);
        mainBinding.setArr(strs);
        mainBinding.setOnclick(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click1:
//                Toast.makeText(this, "click1",Toast.LENGTH_LONG).show();
                NewBeeToastUtils.showToastLong(this, "click1");
                break;
            case R.id.click2:
//                Toast.makeText(this, "click2",Toast.LENGTH_LONG).show();
                NewBeeToastUtils.showToastLong(this, "click2");
                break;
        }
    }
}
