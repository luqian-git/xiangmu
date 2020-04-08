package com.zhiyou100.gym.util;

import java.util.Calendar;
import java.util.TimeZone;

public class NumTimeNowUtil {

    public static Integer NowTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH) + 1;
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int mmm = calendar.get(Calendar.MILLISECOND);
        int mm = Math.round(mmm / 10);
        //System.out.println(y+"--"+m+"--"+d+"--"+mm); 毫秒值为 3位
        Integer z = y * 1000000 + m * 10000 + d * 100 + mm;
        //返回当前日期加 毫秒值
        return z;
    }
    public static Integer NowDate() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        int y = calendar.get(Calendar.YEAR);
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int mmm = calendar.get(Calendar.MILLISECOND);
        //System.out.println(y+"--"+m+"--"+d+"--"+mm); 毫秒值为 3位
        Integer z = y * 1000000 + d * 10000+mmm;
        //返回当前日期加 毫秒值
        return z;
    }

}
