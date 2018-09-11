package com.zzr.ballcalte.utils;

import com.zzr.ballcalte.bean.BallBean;
import com.zzr.ballcalte.bean.BallsBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 作者：zzr
 * 创建日期：2018/9/8
 * 描述：获取所有排列的组合
 */
public class GetAllBallsUtils {
    public static GetAllBallsUtils instance;

    public static GetAllBallsUtils GetInstance() {
        if (instance == null) {
            instance = new GetAllBallsUtils();
        }
        return instance;
    }

    public List<BallsBean> getAllBalls(List<BallBean> danList, List<BallBean> tuoList, List<BallBean> blueList) {
        int danNum = danList.size();
        int tuoNum = tuoList.size();
        int blueNum = blueList.size();

        int needTuoNum = 6 - danNum;                //需要拖码的个数

        int[] dans = new int[danNum];
        Integer[] tuos = new Integer[tuoNum];
        int[] blues = new int[blueNum];

        for (int i = 0; i < danList.size(); i++) {
            dans[i] = danList.get(i).getNum();
        }

        for (int i = 0; i < tuoList.size(); i++) {
            tuos[i] = tuoList.get(i).getNum();
        }

        for (int i = 0; i < blueList.size(); i++) {
            blues[i] = blueList.get(i).getNum();
        }

        List<BallsBean> list = new ArrayList<>();

        //计算拖码
        try {
            CombineAlgorithm ca = new CombineAlgorithm(tuos, needTuoNum);
            Integer[][] c = ca.getResutl();
            for (int j = 0; j < c.length; j++) {
                //创建一个数组先放入胆码
                int[] balls = new int[6];

                //放入胆码
                if (danNum == 1) {
                    balls[0] = dans[0];
                } else if (danNum == 2) {
                    balls[0] = dans[0];
                    balls[1] = dans[1];
                } else if (danNum == 3) {
                    balls[0] = dans[0];
                    balls[1] = dans[1];
                    balls[2] = dans[2];
                } else if (danNum == 4) {
                    balls[0] = dans[0];
                    balls[1] = dans[1];
                    balls[2] = dans[2];
                    balls[3] = dans[3];
                } else if (danNum == 5) {
                    balls[0] = dans[0];
                    balls[1] = dans[1];
                    balls[2] = dans[2];
                    balls[3] = dans[3];
                    balls[4] = dans[4];
                }

                Integer[] objects = c[j];
                switch (danNum) {
                    case 1:
                        balls[1] = objects[0];
                        balls[2] = objects[1];
                        balls[3] = objects[2];
                        balls[4] = objects[3];
                        balls[5] = objects[4];
                        break;
                    case 2:
                        balls[2] = objects[0];
                        balls[3] = objects[1];
                        balls[4] = objects[2];
                        balls[5] = objects[3];
                        break;
                    case 3:
                        balls[3] = objects[0];
                        balls[4] = objects[1];
                        balls[5] = objects[2];
                        break;
                    case 4:
                        balls[4] = objects[0];
                        balls[5] = objects[1];
                        break;
                    case 5:
                        balls[5] = objects[0];
                        break;
                }
                Arrays.sort(balls);
//                    balls[6] = blues[i];
                for (int blue : blues) {
                    BallsBean ballsBean = creatBallsBean(balls);
                    ballsBean.setBlue(blue);
                    list.add(ballsBean);
                }
//                list.add(creatBallsBean(balls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<BallsBean> getAllBalls(List<BallBean> redList, List<BallBean> blueList) {
        int redNum = redList.size();
        int blueNum = blueList.size();

        int needTuoNum = 6;                //需要红球的个数

        Integer[] dans = new Integer[redNum];
        int[] blues = new int[blueNum];

        for (int i = 0; i < redList.size(); i++) {
            dans[i] = redList.get(i).getNum();
        }

        for (int i = 0; i < blueList.size(); i++) {
            blues[i] = blueList.get(i).getNum();
        }

        List<BallsBean> list = new ArrayList<>();

        //计算拖码
        try {
            CombineAlgorithm ca = new CombineAlgorithm(dans, needTuoNum);
            Integer[][] c = ca.getResutl();
            for (int j = 0; j < c.length; j++) {
                //创建一个数组先放入胆码
                int[] balls = new int[6];

                Integer[] objects = c[j];
                balls[0] = objects[0];
                balls[1] = objects[1];
                balls[2] = objects[2];
                balls[3] = objects[3];
                balls[4] = objects[4];
                balls[5] = objects[5];

                Arrays.sort(balls);
//                    balls[6] = blues[i];
                for (int blue : blues) {
                    BallsBean ballsBean = creatBallsBean(balls);
                    ballsBean.setBlue(blue);
                    list.add(ballsBean);
                }
//                list.add(creatBallsBean(balls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public int getTotalNum(int danNum, int tuoNum, int blueNum) {
        int totalNum = 0;
        int needTuoNum = 6 - danNum;                //需要拖码的个数
        int temp = tuoNum - needTuoNum;

        int tuoNum_ = tuoNum;
        while (tuoNum > 1) {
            tuoNum_ *= (tuoNum - 1);
            tuoNum--;
        }
        int needTuoNum_ = needTuoNum;
        while (needTuoNum > 1) {
            needTuoNum_ *= (needTuoNum - 1);
            needTuoNum--;
        }

        int temp_ = temp;
        if (temp == 0 || temp == 1) {
            temp_ = 1;
        } else {
            while (temp > 1) {
                temp_ *= (temp - 1);
                temp--;
            }
        }

        totalNum = tuoNum_ / needTuoNum_ / temp_ * blueNum;
        return totalNum;
    }

    public static BallsBean creatBallsBean(int[] balls) {
        BallsBean ballsBean = new BallsBean();
        ballsBean.setRed1(balls[0]);
        ballsBean.setRed2(balls[1]);
        ballsBean.setRed3(balls[2]);
        ballsBean.setRed4(balls[3]);
        ballsBean.setRed5(balls[4]);
        ballsBean.setRed6(balls[5]);
//        ballsBean.setBlue(balls[6]);

        return ballsBean;
    }
}
