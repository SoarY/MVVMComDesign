package com.soar.sign.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.soar.common.router.RoutePath;
import com.soar.mvvm.base.BaseActivity;
import com.soar.sign.BR;
import com.soar.sign.R;
import com.soar.sign.vm.SignLoginViewModel;

import androidx.databinding.ViewDataBinding;

/**
 * NAME：YONG_
 * Created at: 2019/1/10
 * Describe:
 */
@Route(path = RoutePath.Sign.SIGN_LOGIN)
public class LoginActivity extends BaseActivity<ViewDataBinding, SignLoginViewModel> {/*SignActivityLoginBinding*/

    public static final String CID = "cid";
    public static final String CHAPTER_NAME = "chapterName";

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.sign_activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.vm;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
    }

    private void initData() {
        viewModel.getNaviJson();
    }
}
