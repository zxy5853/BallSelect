package com.zzr.ballcalte.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 作者：zzr
 * 创建日期：2018/9/11
 * 描述：
 */
public class BallResultBean implements Parcelable, MultiItemEntity {
    //条目标志，0为结果，1为号码
    private int itemType;

    private int qihao;
    private int redHe;
    private int allHe;
    private int allPingJun;
    private int redPingJun;
    private int red1;
    private int red2;
    private int red3;
    private int red4;
    private int red5;
    private int red6;
    private int blue;

    protected BallResultBean(Parcel in) {
        itemType = in.readInt();
        qihao = in.readInt();
        redHe = in.readInt();
        allHe = in.readInt();
        allPingJun = in.readInt();
        redPingJun = in.readInt();
        red1 = in.readInt();
        red2 = in.readInt();
        red3 = in.readInt();
        red4 = in.readInt();
        red5 = in.readInt();
        red6 = in.readInt();
        blue = in.readInt();
    }

    public static final Creator<BallResultBean> CREATOR = new Creator<BallResultBean>() {
        @Override
        public BallResultBean createFromParcel(Parcel in) {
            return new BallResultBean(in);
        }

        @Override
        public BallResultBean[] newArray(int size) {
            return new BallResultBean[size];
        }
    };

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public int getRed1() {
        return red1;
    }

    public void setRed1(int red1) {
        this.red1 = red1;
    }

    public int getRed2() {
        return red2;
    }

    public void setRed2(int red2) {
        this.red2 = red2;
    }

    public int getRed3() {
        return red3;
    }

    public void setRed3(int red3) {
        this.red3 = red3;
    }

    public int getRed4() {
        return red4;
    }

    public void setRed4(int red4) {
        this.red4 = red4;
    }

    public int getRed5() {
        return red5;
    }

    public void setRed5(int red5) {
        this.red5 = red5;
    }

    public int getRed6() {
        return red6;
    }

    public void setRed6(int red6) {
        this.red6 = red6;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public BallResultBean() {
    }

    public int getQihao() {
        return qihao;
    }

    public void setQihao(int qihao) {
        this.qihao = qihao;
    }

    public int getRedHe() {
        return redHe;
    }

    public void setRedHe(int redHe) {
        this.redHe = redHe;
    }

    public int getAllHe() {
        return allHe;
    }

    public void setAllHe(int allHe) {
        this.allHe = allHe;
    }

    public int getAllPingJun() {
        return allPingJun;
    }

    public void setAllPingJun(int allPingJun) {
        this.allPingJun = allPingJun;
    }

    public int getRedPingJun() {
        return redPingJun;
    }

    public void setRedPingJun(int redPingJun) {
        this.redPingJun = redPingJun;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(itemType);
        dest.writeInt(qihao);
        dest.writeInt(redHe);
        dest.writeInt(allHe);
        dest.writeInt(allPingJun);
        dest.writeInt(redPingJun);
        dest.writeInt(red1);
        dest.writeInt(red2);
        dest.writeInt(red3);
        dest.writeInt(red4);
        dest.writeInt(red5);
        dest.writeInt(red6);
        dest.writeInt(blue);
    }
}
