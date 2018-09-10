package com.zzr.ballcalte.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 作者：zzr
 * 创建日期：2018/9/10
 * 描述：
 */
public class ReadJsonUtils {

    public static String read(Context context, String file) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(file)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Log.e(file, "getRasKey: " + stringBuilder.toString());
        return stringBuilder.toString();
    }
}
