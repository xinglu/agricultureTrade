package com.sy.graduationPro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Amos on 2018/6/6.
 */
public class TestDemo {

    public static void main(String[] args){
        String str = "500(个)";
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        System.out.println(m.replaceAll("").trim());
        System.out.println(m.replaceAll("").trim().length()-1);
        System.out.println(str.substring(m.replaceAll("").trim().length(), str.length()));
    }
}
