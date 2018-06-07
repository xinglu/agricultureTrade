package com.sy.graduationPro.service;

import com.sy.graduationPro.vo.GoodsOrderVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Amos on 2018/6/4.
 */
@Service(value = "sellGoodsService")
public interface ISellGoodsService {

    //添加售卖的商品
    String addSellGoods(String sellName, String userName, String goodsName, String picPath,
                        String price, String quantity);

    String uploadPic(String picName, byte[] picContent);

    String userBuyGoods(String userName, String orderSign, Integer storeId,
                        Integer goodsId, Integer count, Float coast);

    List<GoodsOrderVO> getBuyOrder(String userName);
}
