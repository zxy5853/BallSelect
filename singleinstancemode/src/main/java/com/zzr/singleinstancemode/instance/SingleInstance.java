package com.zzr.singleinstancemode.instance;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：线程安全的懒汉式单例模式
 */
public class SingleInstance {
    private static volatile SingleInstance instance = null;

    private SingleInstance() {}

    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }

        return instance;
    }
}
