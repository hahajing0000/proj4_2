package com.zy.net.retrofit.converter;

import com.alibaba.fastjson.JSON;
import com.zy.common.log.ZLog;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Converter;

/**
 * @author:zhangyue
 * @date:2020/4/21
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private Type mType;

    public FastJsonResponseBodyConverter(Type _t) {
        this.mType = _t;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        BufferedSource buffer = null;
        try {
            buffer = Okio.buffer(value.source());
            String result = buffer.readUtf8();

            return JSON.parseObject(result, mType);
        } catch (Exception ex) {
            ZLog.getInstance().e(ex.getMessage());
        } finally {
            if (null != buffer) {
                buffer.close();
            }
        }
        return null;
    }
}
