package com.zzr.ballcalte.utils;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * 作者：zzr
 * 创建日期：2018/9/10
 * 描述：
 */
public class RealmHelper<T extends RealmObject> {
//    private RealmHelper instance;
    private Realm realm;

//    public RealmHelper getInstance() {
//        if (instance == null) {
//            synchronized (RealmHelper.class) {
//                if (instance == null)
//                    instance = new RealmHelper();
//            }
//        }
//        return instance;
//    }

    public RealmHelper() {
        initRealm();
    }

    private void initRealm() {
        realm = Realm.getDefaultInstance();
    }

    /**
     * 增
     */
    public void add2Realm() {

    }

    public void copyObj2Realm(T t) {
        realm.beginTransaction();
        realm.copyToRealm(t);
        realm.commitTransaction();
    }

    /**
     * 查
     */
    public List<T> findAll(Class clazz) {
        RealmResults<T> userList = realm.where(clazz).findAll();
        return userList;
    }

    /**
     * 根据分页查询，默认每次返回十条
     *
     * @param pageNum
     * @return
     */
    public List<T> findByPage(Class clazz, int pageNum, Integer dataNum) {
        List<T> allData = findAll(clazz);
        List<T> resultList = new ArrayList<>();
        if (resultList.size() > 0) resultList.clear();

        int everyNum = 10;
        if (dataNum != null)
            everyNum = dataNum;

        if (pageNum < 1) return null;
        int allNum = allData.size();
        int index = allNum - everyNum * pageNum;
        if (index >= 0) {
            for (int i = 0; i < everyNum; i++) {
                resultList.add(allData.get(index));
                index++;
            }
        } else if (index < 0) {
            if (index > -everyNum) {
                for (int i = 0; i < allNum - everyNum * (pageNum - 1); i++) {
                    resultList.add(allData.get(i));
                }
            } else if (index <= -everyNum) {

            }
        }
        return resultList;
    }

    public List<T> findByKey(Class clazz, String key, String value) {
        RealmResults<T> userList = realm.where(clazz).equalTo(key, value).findAll();
        return userList;
    }

    /**
     * 改
     */
//    public void modifyData(final Class clazz,final String key,final String value,final) {
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                //先查找后得到User对象
//                RealmResults<T> userList = realm.where(clazz).equalTo(key, value).findAll();
//                user.setAge(26);
//            }
//        });
//    }
    public void close() {
        realm.close();
    }
}
