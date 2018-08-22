package com.zzr.singleinstancemode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zzr.singleinstancemode.factory.abstrctfactory.AudiCarFactory;
import com.zzr.singleinstancemode.factory.prototype.CompanyOrder;
import com.zzr.singleinstancemode.factory.prototype.OrderDealFactory;

public class MainActivity extends AppCompatActivity {

    private AudiCarFactory audiCarFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audiCarFactory = new AudiCarFactory();
    }

    public void startCreat(View view) {
        audiCarFactory.creatCar().makeCar("生产一辆奥迪汽车");

        OrderDealFactory orderDealFactory = new OrderDealFactory();
        CompanyOrder order = new CompanyOrder();
        order.setNum(4500);
        order.setName("公司订单");
        orderDealFactory.dealOrder(order);
    }
}
