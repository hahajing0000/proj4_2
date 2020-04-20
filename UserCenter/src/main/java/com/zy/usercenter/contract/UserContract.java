package com.zy.usercenter.contract;

import com.zy.core.BasePresenter;
import com.zy.core.IModel;
import com.zy.core.IView;
import com.zy.core.Repository;
import com.zy.net.protocol.resp.BaseEntity;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.protocol.resp.UserEntity;

import io.reactivex.Observable;

/**
 * @author:zhangyue
 * @date:2020/4/20
 * 用户模块契约
 */
public interface UserContract {

    interface UserModel extends IModel{
        Observable<UserEntity> register(UserEntity userEntity);

        Observable<BaseEntity<TestUserEntity>> register2(TestUserEntity testUserEntity);
    }

    abstract class UserRepository extends Repository<UserModel>{
        public abstract Observable<UserEntity> register(UserEntity userEntity);
        public abstract Observable<BaseEntity<TestUserEntity>> register2(TestUserEntity testUserEntity);
    }

    interface UserView extends IView{
        void registerSuccess();
        void registerFailed();
    }

    abstract class UserPresenter extends BasePresenter<UserRepository,UserView>{

        public UserPresenter(UserView _v) {
            super(_v);
        }

        public abstract void register(UserEntity userEntity);
        public abstract void register2(TestUserEntity testUserEntity);
    }

}
