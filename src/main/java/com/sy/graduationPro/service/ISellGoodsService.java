package com.sy.graduationPro.service;

import org.springframework.stereotype.Service;

/**
 * Created by Amos on 2018/6/4.
 */
@Service(value = "sellGoodsService")
public interface ISellGoodsService {

    //添加售卖的商品
    String addSellGoods(String sellName, String userName, String goodsName, String picPath,
                        Float price, Integer quantity);

    String uploadPic(String picName, byte[] picContent);
}
