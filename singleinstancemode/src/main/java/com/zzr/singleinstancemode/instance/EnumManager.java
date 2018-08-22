package com.zzr.singleinstancemode.instance;

/**
 * 作者：zzr
 * 创建日期：2018/8/22
 * 描述：枚举单例模式
 */
public enum EnumManager {
    SDCardManager(10)
            {

                @Override
                public EnumManager getSingle() {
                    return SDCardManager;
                }


            }
    ,
    HttpManager(1) {
        @Override
        public EnumManager getSingle() {
            return null;
        }
    };

    public SdCardImpl getSingleton()
    {
        return new SdCardImpl();
    }


    public abstract EnumManager getSingle();
    private  EnumManager(int type)
    {

    }
}
