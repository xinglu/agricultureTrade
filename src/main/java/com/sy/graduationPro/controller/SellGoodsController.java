package com.sy.graduationPro.controller;

import com.sy.graduationPro.common.response.ResponseMsg;
import com.sy.graduationPro.common.util.StrUtil;
import com.sy.graduationPro.service.ISellGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Amos on 2018/6/4.
 */
@RestController
@RequestMapping("/sell")
public class SellGoodsController {

    @Autowired
    private ISellGoodsService sellGoodsService;

    //图片上传
    @RequestMapping("/upload/pic")
    @ResponseBody
    public ResponseMsg uploadPic(@RequestParam("file") MultipartFile file) throws IOException {

        String resPath = sellGoodsService.uploadPic(file.getOriginalFilename(), file.getBytes());
        return ResponseMsg.success(resPath);
    }

    //添加售卖的商品
    @GetMapping("/add/sellGoods")
    @ResponseBody
    public ResponseMsg addSellGoods(String sellName, String userName, String goodsName, String picPath,
                                    String price, String quantity) {
        if (StrUtil.isEmpty(sellName, userName, picPath, goodsName, price, quantity)) {
            return ResponseMsg.fail();
        }

        String res = sellGoodsService.addSellGoods(sellName, userName, goodsName,
                picPath, Float.valueOf(price), Integer.valueOf(quantity));

        return ResponseMsg.success(res);
    }
}
