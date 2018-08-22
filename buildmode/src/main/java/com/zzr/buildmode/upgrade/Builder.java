package com.zzr.buildmode.upgrade;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：具体建造者，造房子具体的施工人员，受抽象建造者（也就是 建造手册）的约束,建造完成后要返回具体的房子给用户
 * 持有房子的引用
 */
public class Builder {
    private HouseParmas houseParmas = new HouseParmas();
    private HouseBean houseBean = new HouseBean();

    public Builder buildFloor(String floor) {
        houseParmas.floor = floor;
        return this;
//        houseBean.setFloor("高级打蜡抹油摔不死你地板！");
    }

    public Builder buildWindow(String window) {
        houseParmas.window = window;
        return this;
//        houseBean.setWindow("超级不挡风不挡雨不透明窗户！");
    }

    public HouseBean build() {
        houseBean.setParmas(houseParmas);
        return houseBean;
    }

    public class HouseParmas {
        public String floor;
        public String window;
    }
}
