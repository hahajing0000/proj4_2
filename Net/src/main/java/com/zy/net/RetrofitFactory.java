package com.zy.net;

import com.zy.net.common.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author:zhangyue
 * @date:2020/4/18
 *
 */
public class RetrofitFactory {
    private static volatile RetrofitFactory instance=null;
    private Retrofit retrofit;
    private OkHttpClient.Builder builder;

    private RetrofitFactory(){
        initRetrofit();
    }

    /**
     * 创建/初始化Retrofit
     */
    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Config.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createOkhttpClient())
                .build();
    }

    /**
     *
     * @return
     */
    private OkHttpClient createOkhttpClient() {

        return getBuilder()
                .addNetworkInterceptor(createLogInterceptor())
                //.addInterceptor()
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    /**
     * 创建OkHttp的请求日志拦截器
     * @return
     */
    private Interceptor createLogInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    /**
     * 创建OkHttpClient.Builder
     * @return
     */
    private OkHttpClient.Builder getBuilder(){
        if (null==builder){
            builder = new OkHttpClient.Builder();
        }

        return builder;
    }

    /**
     * Double Check单例  解决多线程引起的并发问题
     * @return
     */
    public static RetrofitFactory getInstance(){
        if (null==instance){
            synchronized (RetrofitFactory.class){
                if (null==instance){
                    instance=new RetrofitFactory();
                }
            }
        }
        return instance;
    }


    /**
     * 创建服务
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
      return  retrofit.create(service);
    }
}
