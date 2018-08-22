package com.zzr.buildmode.standard;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：设计者（指导者），指导房屋怎么设计，知道工人的能力，能够指导工人去建房
 * 持有具体建造者的引用
 */
public class Designer {
    public HouseBean designerHouse(Builder builder) {
        builder.buildFloor();
        builder.buildWindow();
        return builder.buildHouse();
    }
}
