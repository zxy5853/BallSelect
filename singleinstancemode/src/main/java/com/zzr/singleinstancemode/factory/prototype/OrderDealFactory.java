package com.zzr.singleinstancemode.factory.prototype;

import android.util.Log;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：
 */
public class OrderDealFactory {
    public void dealOrder(IOrder iOrder) {
        Log.e("pritotype-->", "原订单地址：" + iOrder.hashCode());
        int num = iOrder.getNum();
        while (num > 0) {
            IOrder order = (IOrder) iOrder.clonePrototype();

            order.setNum(num > 1000 ? 1000 : num);
            num-=1000;
            Log.e("pritotype-->", "订单----     number  "+order.getNum()+
                    "   地址  :  "+order.hashCode());
        }
    }
}
