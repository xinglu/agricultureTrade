package com.sy.graduationPro.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.sy.graduationPro.common.config.AlipayConfig;
import com.sy.graduationPro.common.response.OtherInfo;
import com.sy.graduationPro.common.response.ResponseMsg;
import com.sy.graduationPro.common.util.StrUtil;
import com.sy.graduationPro.service.ISellGoodsService;
import com.sy.graduationPro.vo.GoodsOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by Amos on 2018/6/4.
 */
@RestController
@RequestMapping("/sell")
public class SellGoodsController {

    @Autowired
    private ISellGoodsService sellGoodsService;

    private String body;

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
                picPath, price, quantity);

        return ResponseMsg.success(res);
    }

    @PostMapping("/order")
    @ResponseBody
    public void buyGoods(String userName, String goodsId, String storeId,
                         String title, String count, String price, HttpServletResponse response) throws IOException {

        //准备订单信息
        String orderSgn = StrUtil.uuid();
        price = StrUtil.getNumFromStr(price);
        float total = Integer.valueOf(count) * Float.valueOf(price);

        //接入支付宝支付
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.gatewayUrl,
                AlipayConfig.app_id,
                AlipayConfig.merchant_private_key,
                "json",
                AlipayConfig.charset,
                AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);

        String b = goodsId + "-" + storeId + "-" + userName + "-" + count;
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderSgn;
        //付款金额，必填
        String total_amount = total + "";
        //订单名称，必填
        String subject = title;
        //商品描述，可空
        body = "";
        body = goodsId + "-" + storeId + "-" + userName + "-" + count;

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");


        //请求
        String result = "";
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        //输出
        response.setContentType("text/html;charset=" + AlipayConfig.charset);
        response.getWriter().write(result);
        response.getWriter().flush();
        response.getWriter().close();

        return;
    }

    @GetMapping("/notify")
    @ResponseBody
    public ResponseMsg successNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //准备订单信息
        String title = request.getParameter("subject");
        String pay_amount = request.getParameter("total_amount");
        String orderSign = request.getParameter("out_trade_no");
        String[] desc = body.split("-");
        String goodsId = desc[0];
        String storeId = desc[1];
        String userName = desc[2];
        String count = desc[3];

        String res = sellGoodsService.userBuyGoods(userName, orderSign, Integer.valueOf(storeId),
                Integer.valueOf(goodsId), Integer.valueOf(count), Float.valueOf(pay_amount));

        return ResponseMsg.success(res);
    }

    @GetMapping("/get/orders")
    @ResponseBody
    public ResponseMsg getOrders(String userName) {

        if (StrUtil.isEmpty(userName)) {
            return ResponseMsg.fail("参数错误");
        }

        List<GoodsOrderVO> res = sellGoodsService.getBuyOrder(userName);
        return ResponseMsg.success(res, new OtherInfo(res.size()));
    }
}
