package com.zy.storage.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.zy.common.app.AppUtils;

/**
 * @author:zhangyue
 * @date:2020/4/25 SP工具类
 */
public class SPUtils {
    /**
     * 被存储的XML文件名
     */
    private final String SPFILENAME = "ZSPData";

    //单例
    private static volatile SPUtils instance = null;

    //sp 实例
    private SharedPreferences sharedPreferences;

    private SPUtils() {
        sharedPreferences = getContext().getSharedPreferences(SPFILENAME, Context.MODE_PRIVATE);
    }

    public static SPUtils getInstance() {
        if (null == instance) {
            synchronized (SPUtils.class) {
                if (null == instance) {
                    return new SPUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 获取Common库中的应用上下文环境
     *
     * @return
     */
    private Context getContext() {
        return AppUtils.getContext();
    }

    /**
     * 获取SP中的编辑器
     *
     * @return
     */
    public SharedPreferences.Editor getEditor() {

        return sharedPreferences.edit();
    }

    /**
     * 向SP存入数据
     *
     * @param key   key
     * @param value 数据
     * @param <T>   基础类型
     */
    public <T> void put(String key, T value) {
        SharedPreferences.Editor editor = getEditor();
        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        }
        editor.commit();
    }

    /**
     * 获取数据
     * @param key key
     * @param defaultValue 默认值
     * @return 拿到的数据
     */
    public Object get(String key,Object defaultValue) {
        if (null==sharedPreferences){
            throw new NullPointerException("sharedPreferences is null");
        }
        if (defaultValue instanceof Boolean){
            return sharedPreferences.getBoolean(key,(Boolean) defaultValue);
        }else if (defaultValue instanceof String){
            return sharedPreferences.getString(key,(String) defaultValue);
        }else if (defaultValue instanceof Integer){
            return sharedPreferences.getInt(key,(Integer)defaultValue);
        }else if (defaultValue instanceof Float){
            return sharedPreferences.getFloat(key,(Float)defaultValue);
        }else if (defaultValue instanceof Long){
            return sharedPreferences.getLong(key,(Long)defaultValue);
        }
        return null;
    }

    /**
     * 根据key删除指定数据
     * @param key key
     */
    public void removeByKey(String key){
        SharedPreferences.Editor editor = getEditor();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 判断数据是否存在
     * @param key key
     * @return
     */
    public boolean contains(String key){
        if (null==sharedPreferences){
            throw new NullPointerException("sharedPreferences is null");
        }
        return sharedPreferences.contains(key);
    }

    /**
     * 情况SP中所有数据
     */
    public void clear(){
        SharedPreferences.Editor editor = getEditor();
        editor.clear();
        editor.commit();
    }

}
