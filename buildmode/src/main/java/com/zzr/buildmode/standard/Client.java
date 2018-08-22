package com.zzr.buildmode.standard;

import android.util.Log;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：用户
 */
public class Client {
    public void startBuildHouse() {
        Builder builder = new Builder();
        Designer designer = new Designer();
        HouseBean houseBean = designer.designerHouse(builder);

        Log.e("builder-->", "floor:" + houseBean.getFloor() + "   window:" + houseBean.getWindow());
    }
}
