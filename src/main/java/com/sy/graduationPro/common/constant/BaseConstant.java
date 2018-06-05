package com.sy.graduationPro.common.constant;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunguiyong on 2018/5/21.
 */
public class BaseConstant {
    public static Multimap<String, String> goodMap = HashMultimap.create();

    static {
        goodMap.put("生鲜水果","草莓");
        goodMap.put("新鲜蔬菜","竹笋");
        goodMap.put("畜牧水产","羊");
        goodMap.put("米面粮油","大米");
        goodMap.put("农副产品","红茶");
        goodMap.put("花卉苗木","牡丹");
        goodMap.put("中草药材","人身");
        goodMap.put("地方特产","老北京灌肠");
    }


    public static Map<String, Integer> authMap = new HashMap<>();

    static{
        authMap.put("普通用户",3);
        authMap.put("卖家",2);
        authMap.put("专家",1);
        authMap.put("管理员",0);
    }
}
