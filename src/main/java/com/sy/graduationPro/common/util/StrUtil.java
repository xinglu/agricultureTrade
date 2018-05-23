package com.sy.graduationPro.common.util;

import org.springframework.util.StringUtils;

/**
 * Created by sunguiyong on 2018/5/18.
 */
public class StrUtil {

    public static boolean isEmpty(String... args) {

        for (String item : args) {
            if (null == item || StringUtils.isEmpty(item.trim())) {
                return true;
            }
        }
        return false;
    }
}
