package com.zy.home.model.repository;

import com.zy.home.callback.ResultCallback;
import com.zy.home.contract.HomeContract;
import com.zy.home.model.service.HomeService;

/**
 * @author:zhangyue
 * @date:2020/4/18
 */
public class HomeRepository extends HomeContract.HomeRepository {
    @Override
    public void getData(ResultCallback callback) {
        mModel.getData(callback);
    }

    @Override
    protected void createModel() {
        mModel=new HomeService();
    }
}
