package com.szgentech.acrademo.email;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

public class YourOwnSender implements ReportSender {
    @Override
    public void send(@NonNull Context context, @NonNull CrashReportData crashReportData) throws ReportSenderException {

        //发送邮件
//        Log.i("YourOwnSender", "send: " + crashReportData.toJSON());
        Mail mail = new Mail("2664706159@qq.com", "okxnwqesqxubdhih");//发送者邮箱：用户名,密码(授权码)
        mail.set_to(new String[]{"1229717912@qq.com"});//接受者邮箱 可以是多个
        mail.set_from("2664706159@qq.com");//邮件来源,发送者邮箱
        mail.set_subject("Acra项目错误日志");//设置主题标题
        mail.setBody(crashReportData.toString());
        try {
            if (mail.send()) {
                Log.i("YourOwnSender", "send: 发送成功");
            } else {
                Log.i("YourOwnSender", "send: 发送失败");
            }
        } catch (Exception e) {
            Log.e("YourOwnSender", "send: 发送异常");
            e.printStackTrace();
        }
    }
}
