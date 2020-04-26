package com.zy.usercenter.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zy.common.log.ZLog;
import com.zy.storage.common.SPUtils;
import com.zy.storage.greendao.ZDaoManager;
import com.zy.storage.greendao.entity.TestEntity;
import com.zy.usercenter.R;

public class SPActivity extends AppCompatActivity {
    private Button btnSpTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_p);

        btnSpTest = (Button) findViewById(R.id.btn_sp_Test);

        btnSpTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String data="i am sp test data";
//                SPUtils.getInstance().put("testkey",data);
//
//                String testkey = (String) SPUtils.getInstance().get("testkey", "");
//
//                SPUtils.getInstance().removeByKey("testkey");
//
//                String d= (String) SPUtils.getInstance().get("testkey","");
//
//                ZLog.getInstance().d(d);
//
//                TestEntity testEntity=new TestEntity();
//                testEntity.setUsername("zhangsan");
//                testEntity.setOther("");
//                Long currentId = ZDaoManager.getInstance().addTestEntity(testEntity);
//
//                TestEntity testEntity1 = ZDaoManager.getInstance().getTestEntity(currentId);
//                ZLog.getInstance().d(testEntity1.toString());

//                startActivity(new Intent(SPActivity.this,StorageActivity.class));
                int a=2/0;
            }
        });
    }
}
