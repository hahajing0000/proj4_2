package com.zy.usercenter.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zy.common.log.ZLog;
import com.zy.storage.callback.ResultCallback;
import com.zy.storage.chaincache.StorageChainManager;
import com.zy.usercenter.R;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.storagechain.LoginStorageChain;
import com.zy.usercenter.model.storagechain.RegisterStorageChain;

public class StorageActivity extends AppCompatActivity {
    private Button btnStorageTest;
    private Button btnStorageTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        btnStorageTest = (Button) findViewById(R.id.btn_storage_test);
        btnStorageTest2=findViewById(R.id.btn_storage_test2);

        btnStorageTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestUserEntity testUserEntity=new TestUserEntity();
                testUserEntity.setUsername("小明");
                testUserEntity.setPwd("123456");

                String key="tempdata1";

                //加入链测试
                StorageChainManager.getInstance().addChain(key,new RegisterStorageChain());

                StorageChainManager.getInstance().saveData(key,testUserEntity);

                StorageChainManager.getInstance().getData(key, new ResultCallback<TestUserEntity>() {
                    @Override
                    public void getData(TestUserEntity data) {
                        ZLog.getInstance().d(data.getUsername());
                    }
                });




            }
        });

        btnStorageTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestUserEntity testUserEntity2=new TestUserEntity();
                testUserEntity2.setUsername("小红");
                testUserEntity2.setPwd("123456");

                String key2="tempdata2";

                //加入链测试
                StorageChainManager.getInstance().addChain(key2,new LoginStorageChain());

                StorageChainManager.getInstance().saveData(key2,testUserEntity2);

                StorageChainManager.getInstance().getData(key2, new ResultCallback<TestUserEntity>() {
                    @Override
                    public void getData(TestUserEntity data) {
                        ZLog.getInstance().d(data.getUsername());
                    }
                });
            }
        });

    }
}
