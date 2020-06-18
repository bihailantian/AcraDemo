package com.szgentech.acrademo.email;


import android.content.Context;

import androidx.annotation.NonNull;

import org.acra.config.ACRAConfiguration;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderFactory;

public class YourOwnSenderfactory implements ReportSenderFactory {

    /***
     * 注意这里必须要是空的构造方法
     */
    public YourOwnSenderfactory() {
    }

    @NonNull
    @Override
    public ReportSender create(@NonNull Context context, @NonNull ACRAConfiguration acraConfiguration) {
        return new YourOwnSender();
    }
}