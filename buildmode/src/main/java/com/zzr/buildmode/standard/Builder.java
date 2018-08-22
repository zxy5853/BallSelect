package com.zzr.buildmode.standard;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：具体建造者，造房子具体的施工人员，受抽象建造者（也就是 建造手册）的约束,建造完成后要返回具体的房子给用户
 * 持有房子的引用
 */
public class Builder implements IBuilder {
    private HouseBean houseBean = new HouseBean();
    @Override
    public void buildFloor() {
        houseBean.setFloor("高级打蜡抹油摔不死你地板！");
    }

    @Override
    public void buildWindow() {
        houseBean.setWindow("超级不挡风不挡雨不透明窗户！");
    }

    @Override
    public HouseBean buildHouse() {
        return houseBean;
    }
}
