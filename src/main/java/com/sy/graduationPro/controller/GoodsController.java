package com.sy.graduationPro.controller;

import com.sy.graduationPro.common.response.ResponseMsg;
import com.sy.graduationPro.service.IGoodsService;
import com.sy.graduationPro.vo.GoodsKindVO;
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

    //页面中，各种累显示的列表
    @GetMapping("/gk-list")
    @ResponseBody
    public ResponseMsg listOnView() {
        List<GoodsKindVO> resVO = goodsService.getGoodsAndKind();
        return ResponseMsg.success(resVO);
    }
}
