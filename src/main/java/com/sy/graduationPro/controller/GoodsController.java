package com.sy.graduationPro.controller;

import com.mysql.fabric.Response;
import com.sy.graduationPro.bean.SellGoods;
import com.sy.graduationPro.common.response.OtherInfo;
import com.sy.graduationPro.common.response.ResponseMsg;
import com.sy.graduationPro.common.util.StrUtil;
import com.sy.graduationPro.service.IGoodsService;
import com.sy.graduationPro.vo.GoodsKindVO;
import com.sy.graduationPro.vo.GoodsSellVO;
import com.sy.graduationPro.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/24.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    //页面中，各种类别显示的列表
    @GetMapping("/gk-list")
    @ResponseBody
    public ResponseMsg listOnView() {
        List<GoodsKindVO> resVO = goodsService.getGoodsAndKind();
        return ResponseMsg.success(resVO);
    }

    //获取店铺名称
    @GetMapping("/get/storeName")
    @ResponseBody
    public ResponseMsg getStoreName(String userName) {

        if (StrUtil.isEmpty(userName)) {
            return ResponseMsg.fail("参数错误");
        }
        String resData = goodsService.getStoreName(userName);
        if (resData == "当前用户不存在") {
            return ResponseMsg.fail(resData);
        }
        return ResponseMsg.success(resData);
    }

    @GetMapping("/get/all")
    @ResponseBody
    public ResponseMsg getAllGoods(){

        List<GoodsVO> res = goodsService.getAllGoods();
        return ResponseMsg.success(res, new OtherInfo(res.size()));
    }
}
