package com.zzr.singleinstancemode.factory.prototype;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：原型模式，克隆模式
 */
public interface IOrder extends Prototype {
    int getNum();
    void setNum(int num);
}
