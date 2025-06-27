package com.trueconf.sample;

import android.app.Application;

import com.trueconf.sdk.TrueConfSDK;

public class TestApp5 extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TrueConfSDK.getInstance().registerApp(this);
        TrueConfSDK.getInstance().start(true);
    }
}
