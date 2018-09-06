package com.zzr.commandmode;

import android.util.Log;

/**
 * 作者：zzr
 * 创建日期：2018/8/23
 * 描述：责任链模式，抽象处理类
 */
public abstract class Handler {
    public Handler nextHandler;

    public void handleRequest(AbstractRequest request) {
        if (request.getRequestLevel() == getRequestLevel()) {
            handle(request);
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                Log.e("command-->", "都不能处理！");
            }
        }
    }

    /**
     * 具体处理方法，给之类实现
     *
     * @param request
     */
    public abstract void handle(AbstractRequest request);

    /**
     * 子类的处理级别
     *
     * @return
     */
    public abstract int getRequestLevel();
}
