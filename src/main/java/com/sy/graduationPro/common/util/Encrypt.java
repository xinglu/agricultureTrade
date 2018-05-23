package com.sy.graduationPro.common.util;

/**
 * Created by sunguiyong on 2018/5/18.
 */
public class Encrypt {

    //对密码进行加密
    public static String encrypt(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb = sb.append(str.charAt(i) ^ 1);
        }
        return sb.toString();
    }
}
