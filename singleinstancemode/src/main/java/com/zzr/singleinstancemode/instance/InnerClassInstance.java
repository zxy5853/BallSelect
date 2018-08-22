package com.zzr.singleinstancemode.instance;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：内部类单例模式
 */
public class InnerClassInstance {
    private InnerClassInstance() {

    }

    private static class InstanceHolder {
        private static final InnerClassInstance instance = new InnerClassInstance();
    }

    public static InnerClassInstance getInstance() {
        return InstanceHolder.instance;
    }
}
