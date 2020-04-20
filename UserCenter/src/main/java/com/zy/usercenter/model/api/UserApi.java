package com.zy.usercenter.model.api;

import com.zy.net.protocol.resp.BaseEntity;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.protocol.resp.UserEntity;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author:zhangyue
 * @date:2020/4/20
 * 与后台交互的用户接口
 */
public interface UserApi {

    @POST("/videouser/register")
    Observable<UserEntity> register(@Body UserEntity userEntity);

    @POST("api/User/register")
    Observable<BaseEntity<TestUserEntity>> register2(@Body TestUserEntity testUserEntity);
}
