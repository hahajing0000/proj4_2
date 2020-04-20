package com.zy.usercenter.model.repository;

import com.zy.net.protocol.resp.BaseEntity;
import com.zy.usercenter.contract.UserContract;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.protocol.resp.UserEntity;
import com.zy.usercenter.model.service.UserService;

import io.reactivex.Observable;

/**
 * @author:zhangyue
 * @date:2020/4/20
 * 用户模块数据仓库
 */
public class UserRepository extends UserContract.UserRepository {
    @Override
    public Observable<UserEntity> register(UserEntity userEntity) {

        return mModel.register(userEntity);
    }

    @Override
    public Observable<BaseEntity<TestUserEntity>> register2(TestUserEntity testUserEntity) {
        return mModel.register2(testUserEntity);
    }

    @Override
    protected void createModel() {
        mModel=new UserService();
    }
}
