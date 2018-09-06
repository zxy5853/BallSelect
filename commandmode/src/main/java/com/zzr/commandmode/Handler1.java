package com.zzr.commandmode;

import android.util.Log;

/**
 * 作者：zzr
 * 创建日期：2018/8/23
 * 描述：第一个处理者
 */
public class Handler1 extends Handler {
    @Override
    public void handle(AbstractRequest request) {
        Log.e("command-->", "handle1---->处理了对象" + request.getRequestLevel());
    }

    @Override
    public int getRequestLevel() {
        return 1;
    }
}
