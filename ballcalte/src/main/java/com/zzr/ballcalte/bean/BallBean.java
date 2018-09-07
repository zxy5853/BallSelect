package com.zzr.ballcalte.bean;

/**
 * 作者：zzr
 * 创建日期：2018/9/7
 * 描述：
 */
public class BallBean {
    private int num;
    private int color;  //1是红色，2是蓝色
    private boolean isSelect;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
