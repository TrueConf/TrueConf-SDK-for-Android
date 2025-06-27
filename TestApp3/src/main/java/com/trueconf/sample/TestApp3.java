package com.trueconf.sample;

import android.app.Application;

import com.trueconf.sdk.TrueConfSDK;

public class TestApp3 extends Application {

    public void onCreate() {
		super.onCreate();
		TrueConfSDK.getInstance().registerApp(this);
        TrueConfSDK.getInstance().start(true);
    }
}
