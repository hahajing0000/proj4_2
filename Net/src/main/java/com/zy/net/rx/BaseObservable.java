package com.zy.net.rx;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import androidx.lifecycle.LifecycleOwner;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author:zhangyue
 * @date:2020/4/20
 * 基础的Observable
 */
public class BaseObservable {
    /**
     * 处理Observable
     * @param tObservable
     * @param observer
     * @param <T>
     */
    public static <T> void doObservable(Observable<T> tObservable, BaseObserver<T> observer, LifecycleOwner lifecycleOwner){
        tObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .as(AutoDispose.<T>autoDisposable(AndroidLifecycleScopeProvider.from(lifecycleOwner)))
                .subscribe(observer);
    }
}
