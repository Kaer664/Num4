package edevelopmentandroidcompanydomain.num4.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //通过intent获取数据
        Bundle bundle = intent.getExtras();
        Object[] objs = (Object[]) bundle.get("pdus");//返回object[]，不是object
        //将object数组转换成byte数组
        for (Object obj : objs) {
            byte[] bytes = (byte[]) obj;
            //将byte数组转换成SmsMessage对象
            SmsMessage smsMessage = SmsMessage.createFromPdu(bytes);
            if (smsMessage != null) {
                //smsMessage.getDisplayOriginatingAddress()获取发送者的手机号码
                //smsMessage.getDisplayMessageBody()获取短信内容
                if ("6505551212".equals(smsMessage.getDisplayOriginatingAddress())) {
                    System.out.println(smsMessage.getDisplayMessageBody().substring(0, 24));
                    if ("您正在使用停车专家App的密码找回功能，验证码："
                            .equals(smsMessage.getDisplayMessageBody().substring(0, 24))) {
                        Toast.makeText(context,"验证码：" + smsMessage.getDisplayMessageBody().substring(24),Toast.LENGTH_LONG).show();
                    }
                }
            }
        }
    }
}
