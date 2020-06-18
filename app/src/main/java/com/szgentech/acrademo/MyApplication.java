package com.szgentech.acrademo;

import android.app.Application;

import com.szgentech.acrademo.email.YourOwnSenderfactory;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;


@ReportsCrashes(
        reportSenderFactoryClasses = {YourOwnSenderfactory.class},
        customReportContent = {ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME,
                ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA,
                ReportField.STACK_TRACE, ReportField.LOGCAT},
        resToastText = R.string.msg_acra_toast
)
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        ACRA.init(this);
        super.onCreate();
    }
}
