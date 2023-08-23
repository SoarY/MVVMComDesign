package com.soar.sign;

import android.app.Application;

import com.soar.common.imp.IModuleInit;


public class SignModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(Application application) {
        return false;
    }

    @Override
    public boolean onInitLow(Application application) {
        return false;
    }
}
