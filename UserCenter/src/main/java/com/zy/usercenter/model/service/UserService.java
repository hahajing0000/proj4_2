package com.zy.usercenter.model.service;

import com.zy.net.RetrofitFactory;
import com.zy.net.protocol.resp.BaseEntity;
import com.zy.usercenter.contract.UserContract;
import com.zy.usercenter.model.api.UserApi;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.protocol.resp.UserEntity;

import io.reactivex.Observable;

/**
 * @author:zhangyue
 * @date:2020/4/20
 * 用户模块的Service
 */
public class UserService implements UserContract.UserModel {

    @Override
    public Observable<UserEntity> register(UserEntity userEntity) {
        UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);
        Observable<UserEntity> register = userApi.register(userEntity);
        return register;
    }

    @Override
    public Observable<BaseEntity<TestUserEntity>> register2(TestUserEntity testUserEntity) {
        UserApi userApi = RetrofitFactory.getInstance().create(UserApi.class);
        Observable<BaseEntity<TestUserEntity>> baseEntityObservable = userApi.register2(testUserEntity);

        return baseEntityObservable;
    }
}
