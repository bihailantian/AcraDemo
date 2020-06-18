package com.szgentech.acraserver;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

public class CrashSender implements ReportSender {

    private static final String TAG = CrashSender.class.getSimpleName();

    @Override
    public void send(@NonNull Context context, @NonNull CrashReportData errorContent) throws ReportSenderException {
        // 自定义需要发送的内容到后台
        OkHttpUtils.get()
                .url("http://192.168.10.122:8080/log")
                .addParams("APP_VERSION_CODE", errorContent.getProperty(ReportField.APP_VERSION_CODE))
                .addParams("APP_VERSION_NAME", errorContent.getProperty(ReportField.APP_VERSION_NAME))
                .addParams("PACKAGE_NAME", errorContent.getProperty(ReportField.PACKAGE_NAME))
                .addParams("FILE_PATH", errorContent.getProperty(ReportField.FILE_PATH))
                .addParams("PHONE_MODEL", errorContent.getProperty(ReportField.PHONE_MODEL))
                .addParams("ANDROID_VERSION", errorContent.getProperty(ReportField.ANDROID_VERSION))
                .addParams("BUILD", errorContent.getProperty(ReportField.BUILD))
                .addParams("BRAND", errorContent.getProperty(ReportField.BRAND))
                .addParams("STACK_TRACE", errorContent.getProperty(ReportField.STACK_TRACE))
                .addParams("STACK_TRACE_HASH", errorContent.getProperty(ReportField.STACK_TRACE_HASH))
                .addParams("USER_CRASH_DATE", errorContent.getProperty(ReportField.USER_CRASH_DATE))
                .addParams("DUMPSYS_MEMINFO", errorContent.getProperty(ReportField.DUMPSYS_MEMINFO))
                .addParams("DEVICE_ID", errorContent.getProperty(ReportField.DEVICE_ID))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(okhttp3.Call call, Exception e, int i) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String s, int i) {
                        Log.d(TAG, "response=" + s);
                    }
                });
    }
}

