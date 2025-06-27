package com.trueconf.sample;

import androidx.multidex.MultiDexApplication;

import com.trueconf.sdk.TrueConfSDK;

public class TestApp4 extends MultiDexApplication {

	public void onCreate() {
        super.onCreate();
        TrueConfSDK.getInstance().registerApp(this);
        TrueConfSDK.getInstance().start(true);
    }
}
