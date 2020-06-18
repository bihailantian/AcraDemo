package com.szgentech.acraserver;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;


@ReportsCrashes(
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.app_error,
        // 更换默认的发送器
        reportSenderFactoryClasses = {CrashSenderFactory.class}
)
public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        ACRA.init(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}