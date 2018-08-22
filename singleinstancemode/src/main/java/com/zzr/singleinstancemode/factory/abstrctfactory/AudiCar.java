package com.zzr.singleinstancemode.factory.abstrctfactory;

import android.util.Log;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：
 */
public class AudiCar implements ICar {
    @Override
    public void makeCar(String text) {
        Log.e("factory--->", text);
    }
}
