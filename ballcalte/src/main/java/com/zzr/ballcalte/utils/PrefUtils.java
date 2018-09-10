package com.zzr.ballcalte.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.zzr.ballcalte.app.MyApplication;


/**
 * 专门访问和设置SharePreference的工具类, 保存和配置一些设置信息
 *
 * @author Kevin
 */
public class PrefUtils {

    private static final String SHARE_PREFS_NAME = "ball";

    public static void putBoolean(String key, boolean value) {
        SharedPreferences pref = MyApplication.context.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        pref.edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(String key,
                                     boolean defaultValue) {
        SharedPreferences pref = MyApplication.context.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        return pref.getBoolean(key, defaultValue);
    }

    public static void putString(String key, String value) {
        SharedPreferences pref = MyApplication.context.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        pref.edit().putString(key, value).commit();
    }

    public static String getString(String key, String defaultValue) {
        SharedPreferences pref = MyApplication.context.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        return pref.getString(key, defaultValue);
    }

    public static void putInt(String key, int value) {
        SharedPreferences pref = MyApplication.context.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        pref.edit().putInt(key, value).commit();
    }

    public static int getInt(String key, int defaultValue) {
        SharedPreferences pref = MyApplication.context.getSharedPreferences(SHARE_PREFS_NAME,
                Context.MODE_PRIVATE);

        return pref.getInt(key, defaultValue);
    }

}
