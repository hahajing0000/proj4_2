package com.zy.usercenter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.zy.core.ui.BaseActivity;
import com.zy.usercenter.R;
import com.zy.usercenter.contract.UserContract;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.protocol.resp.UserEntity;
import com.zy.usercenter.presenter.UserPresenter;

import java.util.concurrent.TimeUnit;

public class RegisterActivity extends BaseActivity<UserPresenter> implements UserContract.UserView {
    private EditText etRegisterPhonenumber;
    private EditText etRegisterPwd;
    private EditText etRegisterPwd2;
    private Button btnRegisterRegister;

    @Override
    protected void createPresenter() {
        mPresenter=new UserPresenter(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        etRegisterPhonenumber = (EditText) findViewById(R.id.et_register_phonenumber);
        etRegisterPwd = (EditText) findViewById(R.id.et_register_pwd);
        etRegisterPwd2 = (EditText) findViewById(R.id.et_register_pwd2);
        btnRegisterRegister = (Button) findViewById(R.id.btn_register_register);
    }

    @Override
    protected void initEvent() {
        btnRegisterRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = etRegisterPhonenumber.getText().toString();
                String pwd=etRegisterPwd.getText().toString();
                String pwd2=etRegisterPwd2.getText().toString();

//                UserEntity userEntity=new UserEntity();
//                userEntity.setPhoneNum(Integer.parseInt(phoneNumber));
//                userEntity.setUserPassWord(pwd);
//                mPresenter.register(userEntity);

                TestUserEntity testUserEntity=new TestUserEntity();
                testUserEntity.setUsername(phoneNumber);
                testUserEntity.setPwd(pwd);
                mPresenter.register2(testUserEntity);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }



    @Override
    public void registerSuccess() {
        showMsg("register success");
    }

    @Override
    public void registerFailed() {
        showMsg("register failed");
    }

    @Override
    public LifecycleOwner getLifecycleOwner() {
        return this;
    }
}
