package com.sy.graduationPro.controller;

import com.sy.graduationPro.common.response.OtherInfo;
import com.sy.graduationPro.common.response.ResponseMsg;
import com.sy.graduationPro.common.util.StrUtil;
import com.sy.graduationPro.service.IStoreService;
import com.sy.graduationPro.vo.GoodsSellVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Amos on 2018/6/5.
 */
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private IStoreService storeService;

    //用户开通店铺
    @GetMapping("/register")
    @ResponseBody
    public ResponseMsg storeRegister(String userName, String name, String address) {

        if (StrUtil.isEmpty(name, address)) {
            return ResponseMsg.fail("参数错误");
        }
        String resData = storeService.storeRegister(userName, name, address);
        return ResponseMsg.success(resData);
    }

    //查看店铺中的商品
    @GetMapping("/goods")
    @ResponseBody
    public ResponseMsg getGoodsOfStore(String userName) {
        if (StrUtil.isEmpty(userName)) {
            return ResponseMsg.fail();
        }
        List<GoodsSellVO> res = storeService.getGoodsOfStore(userName);
        return ResponseMsg.success(res, new OtherInfo(res.size()));
    }


    @GetMapping("/condition/get_goods")
    @ResponseBody
    public ResponseMsg getGoodsByCondition(String kindName, String goodsName) {

        List<GoodsSellVO> res = storeService.getGoodsByCon(kindName, goodsName);
        return ResponseMsg.success(res, new OtherInfo(res.size()));
    }
}
