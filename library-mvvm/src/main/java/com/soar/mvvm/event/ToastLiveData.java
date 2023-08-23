package com.soar.mvvm.event;


import com.soar.mvvm.base.BaseSingleLiveEvent;

/**
 * NAME：YONG_
 * Created at: 2018/12/21 11
 * Describe:
 */
public class ToastLiveData extends BaseSingleLiveEvent<String> {
    public void show(String message) {
        postValue(message);
    }
}
