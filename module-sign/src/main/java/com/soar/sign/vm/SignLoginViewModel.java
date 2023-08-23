package com.soar.sign.vm;

import android.app.Application;
import android.util.Log;

import com.soar.mvvm.base.BaseViewModel;
import com.soar.network.bean.response.NaviBean;
import com.soar.network.constant.APIMain;
import com.soar.network.exception.APIException;
import com.soar.network.exception.ExceptionEngine;
import com.soar.network.exception.HttpResultFunc;
import com.soar.network.exception.ServerResultFunc;
import com.soar.network.retrofit.RetrofitClient;
import com.soar.network.retrofit.RxObserver;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Observable;

/**
 * NAME：YONG_
 * Created at: 2019/1/11
 * Describe:
 */
public class SignLoginViewModel extends BaseViewModel {

    public SignLoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void getNaviJson() {
        RetrofitClient instance = RetrofitClient.getInstance();
        Observable<List<NaviBean>> observable = instance.getApi(APIMain.API_PLAY_ANDROID).getNaviJson()
                .map(new ServerResultFunc<>())
                .onErrorResumeNext(new HttpResultFunc<>());
        instance.toSubscribe(getLifecycleProvider(), observable, new RxObserver<List<NaviBean>>() {

            @Override
            public void onNext(List<NaviBean> datas) {
                Log.i("SignLoginViewModel", "onNext: "+datas);
            }

            @Override
            protected void onError(APIException ex) {
                Log.i("SignLoginViewModel", "onError: "+ex.getMessage());

                if (ex.getCode() == ExceptionEngine.ERROR.ERROR_NET)
                    uiLiveData.toastEvent.show(ex.getDisplayMessage());
            }
        });
    }
}
