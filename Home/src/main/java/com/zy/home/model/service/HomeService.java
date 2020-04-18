package com.zy.home.model.service;

import com.zy.home.callback.ResultCallback;
import com.zy.home.contract.HomeContract;

/**
 * @author:zhangyue
 * @date:2020/4/18
 */
public class HomeService implements HomeContract.HomeModel {
    @Override
    public void getData(ResultCallback callback) {
        //TODO：访问网络获取数据  读取SP  读取Sqlie 。。。
        //TODO:RxJava Retrofit Okhttp
        String result="我是MVP框架验证的结果";
        callback.success(result);
    }
}
