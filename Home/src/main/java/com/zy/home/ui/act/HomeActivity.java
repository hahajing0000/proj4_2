package com.zy.home.ui.act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zy.common.router.RouterPath;
import com.zy.home.R;

@Route(path = RouterPath.HOME_PATH)
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toast.makeText(this,"123",Toast.LENGTH_SHORT).show();
    }
}
