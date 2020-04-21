package com.zy.usercenter.presenter;

import com.zy.net.protocol.resp.BaseEntity;
import com.zy.net.rx.BaseObservable;
import com.zy.net.rx.BaseObserver;
import com.zy.usercenter.contract.UserContract;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.protocol.resp.UserEntity;
import com.zy.usercenter.model.repository.UserRepository;

import io.reactivex.Observable;

/**
 * @author:zhangyue
 * @date:2020/4/20
 */
public class UserPresenter extends UserContract.UserPresenter {
    public UserPresenter(UserContract.UserView _v) {
        super(_v);
    }

    @Override
    public void register(UserEntity userEntity) {
        Observable<UserEntity> register = mRepository.register(userEntity);
        BaseObservable.doObservable(register,new BaseObserver<UserEntity>(){
            @Override
            public void onNext(UserEntity userEntity) {
                super.onNext(userEntity);
                if (mView!=null&&mView.get()!=null){
                    mView.get().registerSuccess(userEntity);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (mView!=null&&mView.get()!=null){
                    mView.get().registerFailed();
                }
            }
        },mView.get().getLifecycleOwner());
    }

    @Override
    public void register2(TestUserEntity testUserEntity) {
        Observable<BaseEntity<TestUserEntity>> baseEntityObservable = mRepository.register2(testUserEntity);
        BaseObservable.doObservable(baseEntityObservable,new BaseObserver<BaseEntity<TestUserEntity>>(){
            @Override
            public void onNext(BaseEntity<TestUserEntity> testUserEntityBaseEntity) {
                super.onNext(testUserEntityBaseEntity);
                if (mView!=null&&mView.get()!=null){
                    mView.get().registerSuccess(testUserEntityBaseEntity);
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (mView!=null&&mView.get()!=null){
                    mView.get().registerFailed();
                }
            }
        },mView.get().getLifecycleOwner());
    }

    @Override
    protected void createRepository() {
        mRepository=new UserRepository();
    }
}
