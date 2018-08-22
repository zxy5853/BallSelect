package com.zzr.singleinstancemode.factory.abstrctfactory;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：
 */
public class AudiCarFactory implements IFactory {
    @Override
    public ICar creatCar() {
        return new AudiCar();
    }
}
