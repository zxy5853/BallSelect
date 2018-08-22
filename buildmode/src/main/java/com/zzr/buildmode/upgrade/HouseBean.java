package com.zzr.buildmode.upgrade;

import android.util.Log;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：建造的最终产物 --房子
 */
public class HouseBean {
    private String floor;
    private String window;

    public HouseBean setParmas(Builder.HouseParmas parmas) {
        floor = parmas.floor;
        window = parmas.window;

        Log.e("builder-->", "floor:" + floor + "   window:" + window);
        return this;
    }
}
