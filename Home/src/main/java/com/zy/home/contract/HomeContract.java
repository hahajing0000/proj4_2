package com.zy.home.contract;

import com.zy.core.BasePresenter;
import com.zy.core.IModel;
import com.zy.core.IView;
import com.zy.core.Repository;
import com.zy.home.callback.ResultCallback;

/**
 * @author:zhangyue
 * @date:2020/4/18
 */
public interface HomeContract {
    interface HomeModel extends IModel {
        void getData(ResultCallback callback);
    }

    abstract class HomeRepository extends Repository<HomeModel>{
        public abstract void getData(ResultCallback callback);
    }

    interface HomeView extends IView{
        void success(String result);
        void failed(Throwable throwable);
    }

    abstract class HomePresenter extends BasePresenter<HomeRepository,HomeView>{

        public HomePresenter(HomeView _v) {
            super(_v);
        }
        public abstract void getData();
    }
}
