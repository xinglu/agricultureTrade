package com.sy.graduationPro.service;

import com.sy.graduationPro.vo.GoodsKindVO;
import com.sy.graduationPro.vo.GoodsSellVO;
import com.sy.graduationPro.vo.GoodsVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/24.
 */
@Service(value = "goodsService")
public interface IGoodsService {

    List<GoodsKindVO> getGoodsAndKind();

    //获取店铺名称
    String getStoreName(String userName);

    List<GoodsVO> getAllGoods();
}
