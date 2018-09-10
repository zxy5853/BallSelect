package com.zzr.ballcalte.app;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * 作者：zzr
 * 创建日期：2018/9/7
 * 描述：
 */
public class MyApplication extends Application {
    public static Context context;
    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null)
            instance = this;

        if (context == null)
            context = this;

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}
