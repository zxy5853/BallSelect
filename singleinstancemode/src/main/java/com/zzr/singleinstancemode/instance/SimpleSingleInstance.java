package com.zzr.singleinstancemode.instance;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：一个简单的单例模式
 */
public class SimpleSingleInstance {
    private static SimpleSingleInstance instance = null;

    private SimpleSingleInstance() {}

    public static synchronized SimpleSingleInstance getInstance() {
        if (instance == null) {
            instance = new SimpleSingleInstance();
        }
        return instance;
    }
}
