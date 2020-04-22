package com.zy.usercenter.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zy.common.log.ZLog;
import com.zy.usercenter.R;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linked_hashmap);

        LinkedHashMap<String, String> map = new LinkedHashMap<>(0, 0.75f, true);
        for (int i=0;i<10;i++){
            map.put(String.valueOf(i),"value "+i);
        }

        ////////////////////////////////

        map.get("5");
        map.get("7");

        map.put("222","222");



        /////////////////////////////////

        for (Map.Entry<String,String> entry:
             map.entrySet()) {
            ZLog.getInstance().i("key = "+entry.getKey()+"   value = "+entry.getValue());
        }




    }
}
