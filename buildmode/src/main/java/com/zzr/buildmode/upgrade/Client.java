package com.zzr.buildmode.upgrade;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：用户
 */
public class Client {
    public void startBuildHouse() {
        Builder builder = new Builder();
        builder.buildFloor("高级打蜡抹油摔不死你地板！")
                .buildWindow("超级不挡风不挡雨不透明窗户！")
                .build();
    }
}
