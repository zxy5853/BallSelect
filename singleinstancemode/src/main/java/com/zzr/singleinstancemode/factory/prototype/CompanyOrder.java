package com.zzr.singleinstancemode.factory.prototype;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：
 */
public class CompanyOrder implements IOrder {
    private int num;
    private String name;
    @Override
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setNum(int num) {
        this.num = num;

    }

    @Override
    public Prototype clonePrototype() {
        CompanyOrder order = new CompanyOrder();
        order.setName(name);
        order.setNum(num);
        return order;
    }
}
