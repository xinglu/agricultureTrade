package com.sy.graduationPro.common.util;

import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sunguiyong on 2018/5/18.
 */
public class StrUtil {

    private static String regEx="[^0-9]";

    /**
     * 字符串判空
     *
     * @param args
     * @return
     */
    public static boolean isEmpty(String... args) {

        for (String item : args) {
            if (null == item || StringUtils.isEmpty(item.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 生成uuid
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String getNumFromStr(String str){
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
}
