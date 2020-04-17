package com.zy.bawei4project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zy.common.router.RouterPath;

public class MainActivity extends AppCompatActivity {
    private TextView tvTestArouter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        tvTestArouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();
                ARouter.getInstance().build(RouterPath.HOME_PATH).navigation();
            }
        });
    }

    private void initView() {
        tvTestArouter = (TextView) findViewById(R.id.tv_test_arouter);
    }


}
