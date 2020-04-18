package com.zy.home.presenter;

import android.util.Log;

import com.zy.home.callback.ResultCallback;
import com.zy.home.contract.HomeContract;
import com.zy.home.model.repository.HomeRepository;

/**
 * @author:zhangyue
 * @date:2020/4/18
 */
public class HomePresenter extends HomeContract.HomePresenter {
    private final String TAG=HomePresenter.class.getSimpleName();
    public HomePresenter(HomeContract.HomeView _v) {
        super(_v);
    }

    @Override
    public void getData() {
        mRepository.getData(new ResultCallback() {
            @Override
            public void success(String result) {
                if (null!=mView&&null!=mView.get()){
                    mView.get().success(result);
                }
                else{
                    Log.e(TAG,  "mView or mView.get() is Null");
                }
            }
        });
    }

    @Override
    protected void createRepository() {
        mRepository=new HomeRepository();
    }
}
