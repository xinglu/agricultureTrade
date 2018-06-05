package com.sy.graduationPro.service;

import com.sy.graduationPro.vo.GoodsSellVO;
import com.sy.graduationPro.vo.GoodsVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Amos on 2018/6/5.
 */
@Service(value = "storeService")
public interface IStoreService {

    //店铺注册
    String storeRegister(String userName, String name, String address);

    //获取指定店铺的商品
    List<GoodsSellVO> getGoodsOfStore(String userName);

    //跳转到stores页面
    List<GoodsSellVO> getGoodsByCon(String kindName, String goodsName);
}
