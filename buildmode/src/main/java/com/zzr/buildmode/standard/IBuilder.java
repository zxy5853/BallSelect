package com.zzr.buildmode.standard;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：建造者模式中的抽象建造者，类似于工地的施工手册
 */
public interface IBuilder {
    void buildFloor();
    void buildWindow();
    HouseBean buildHouse();
}
