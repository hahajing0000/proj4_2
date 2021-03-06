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
import android.widget.ImageView;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;
import com.zy.common.log.ZLog;
import com.zy.core.ui.BaseActivity;
import com.zy.imageloader.ImageLoader;
import com.zy.imageloader.setting.NormalImageSetting;
import com.zy.net.RetrofitFactory;
import com.zy.net.protocol.resp.BaseEntity;
import com.zy.storage.common.ZLRUCache;
import com.zy.usercenter.R;
import com.zy.usercenter.contract.UserContract;
import com.zy.usercenter.model.protocol.resp.TestUserEntity;
import com.zy.usercenter.model.protocol.resp.UserEntity;
import com.zy.usercenter.presenter.UserPresenter;

import java.util.concurrent.TimeUnit;

public class RegisterActivity extends BaseActivity<UserPresenter> implements UserContract.UserView<BaseEntity<TestUserEntity>> {
    private final String TAG= RegisterActivity.class.getSimpleName();
    private EditText etRegisterPhonenumber;
    private EditText etRegisterPwd;
    private EditText etRegisterPwd2;
    private Button btnRegisterRegister;

    private ImageView ivRegisterImg;

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


        ivRegisterImg = (ImageView) findViewById(R.id.iv_register_img);
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
        ImageLoader.getInstance().loadImage(
                this,
                NormalImageSetting
                    .builder()
                    .url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587450999848&di=195c74b948ab68df24bc8ea2ecd73049&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd009b3de9c82d1587e249850820a19d8bd3e42a9.jpg")
//                    .imageRadius(250)
                    .imageView(ivRegisterImg)
                    .build());

        ZLRUCache.getInstance().put("123","123");
        String result = (String) ZLRUCache.getInstance().get("123");
        ZLog.getInstance().w("result = "+result);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }


    @Override
    public void registerSuccess(BaseEntity<TestUserEntity> result) {
        showMsg(result.getData().getUsername());
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
