package com.zy.home.ui.act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zy.common.router.RouterPath;
import com.zy.core.ui.BaseActivity;
import com.zy.home.R;
import com.zy.home.contract.HomeContract;
import com.zy.home.presenter.HomePresenter;

@Route(path = RouterPath.HOME_PATH)
public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {
    private Button btnMvpTest;
    private TextView tvMvpContent;

    @Override
    protected void createPresenter() {
        mPresenter=new HomePresenter(this);
    }

    @Override
    protected void initEvent() {
        btnMvpTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getData();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        btnMvpTest = (Button) findViewById(R.id.btn_mvp_test);
        tvMvpContent = (TextView) findViewById(R.id.tv_mvp_content);
    }

    @Override
    public void success(String result) {
        showMsg("模拟请求成功");
        tvMvpContent.setText(result);
    }

    @Override
    public void failed(Throwable throwable) {
        showMsg(throwable.getMessage());
    }
}
