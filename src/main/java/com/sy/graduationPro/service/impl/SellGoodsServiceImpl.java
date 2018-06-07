package com.sy.graduationPro.service.impl;

import com.sy.graduationPro.bean.*;
import com.sy.graduationPro.common.util.StrUtil;
import com.sy.graduationPro.dao.*;
import com.sy.graduationPro.service.ISellGoodsService;
import com.sy.graduationPro.vo.GoodsOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2018/6/4.
 */
@Service
public class SellGoodsServiceImpl implements ISellGoodsService {

    @Autowired
    private IStoreDAO storeDAO;
    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private ISellGoodsDAO sellGoodsDAO;
    @Autowired
    private IGoodsDAO goodsDAO;
    @Autowired
    private IGoodsOrderDAO goodsOrderDAO;

    private String uploadPicPath = "../webapps/agriculture/WEB-INF/classes/static/pic/copyPic/";

    @Override
    public String addSellGoods(String sellName, String userName, String goodsName,
                               String picPath, String price, String quantity) {

        User user = userDAO.findByName(userName);
        if (user == null) {
            return "当前用户不存在";
        }

        Store store = storeDAO.findBySellerId(user.getId());
        if (store == null) {
            return "当前店铺不存在";
        }

        Goods goods = goodsDAO.findByGoodsName(goodsName);
        if (goods == null) {
            return "当前商品不存";
        }

        SellGoods exists = sellGoodsDAO.fetchByStoreAndGoodsId(store.getId(), goods.getId());
        if (exists != null) {
            return "当前店铺已有此类产品";
        }
        String sellNum = StrUtil.getNumFromStr(quantity);
        sellNum = "0" + quantity.substring(sellName.length(), quantity.length());
        SellGoods sellGoods = new SellGoods(sellName, store.getId(), goods.getId(),
                price, quantity, sellNum, picPath);
        sellGoodsDAO.save(sellGoods);
        return "添加商品成功";
    }

    @Override
    public String uploadPic(String picName, byte[] picContent) {
        String name = copyPicture(picName, picContent);
        return "http://localhost:8080/agriculture/pic/copyPic/" + name;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String userBuyGoods(String userName, String orderSign, Integer storeId,
                               Integer goodsId, Integer count, Float coast) {

        //获取买家id
        User buyer = userDAO.findByName(userName);
        if (buyer == null) {
            return "没有当前用户";
        }
        //获取买家id
        Store store = storeDAO.findById(storeId);
        if (store == null) {
            return "当前店铺不存在";
        }
        User seller = userDAO.findByid(store.getSellerId());

        GoodsOrder goodsOrder = new GoodsOrder(orderSign, buyer.getId(), seller.getId(),
                goodsId, count, coast, buyer.getAddress(), seller.getAddress());
        goodsOrderDAO.save(goodsOrder);
        Integer sellNum = store.getSellNum() + 1;
        //卖出一件商品，店铺卖出货物的数量加1
        storeDAO.addSellNum(sellNum, storeId);

        //商品的销量修改
        SellGoods sellGoods = sellGoodsDAO.fetchByStoreAndGoodsId(storeId, goodsId);
        String orignSellNum = sellGoods.getSellNum();
        String orignNum = StrUtil.getNumFromStr(orignSellNum);
        Integer goodsSellNum = Integer.valueOf(orignNum) + count;
        sellGoodsDAO.addSellNum(
                goodsSellNum + orignSellNum.substring(orignNum.length(), orignSellNum.length()),
                sellGoods.getId());

        return "下订单成功";
    }

    @Override
    public List<GoodsOrderVO> getBuyOrder(String userName) {
        List<GoodsOrderVO> resVo = new ArrayList<>();

        User buyer = userDAO.findByName(userName);
        if (buyer == null) {
            return resVo;
        }
        List<GoodsOrder> goodsOrder = goodsOrderDAO.findByBuyerId(buyer.getId());
        if (goodsOrder == null) {
            return resVo;
        }

        for (GoodsOrder item : goodsOrder) {
            Store store = storeDAO.findBySellerId(item.getSellerId());
            if (store == null) {
                return resVo;
            }
            SellGoods sellGoods = sellGoodsDAO.fetchByStoreAndGoodsId(store.getId(),
                    item.getProductId());
            if (sellGoods == null) {
                return resVo;
            }
            GoodsOrderVO vo = new GoodsOrderVO(item);
            vo.setPic(sellGoods.getPic());
            vo.setSellName(sellGoods.getName());
            resVo.add(vo);
        }
        return resVo;
    }


    //根据图片路径，将图片转到resources目录下
    private String copyPicture(String picName, byte[] picContent) {
        uploadPicPath = "../webapps/agriculture/WEB-INF/classes/static/pic/copyPic/";
        String type = picName.split("\\.")[1];

        String name = System.currentTimeMillis() + "." + type;
        uploadPicPath += name;
        try {
            // 打开输出流,写入到服务器
            OutputStream fos = new FileOutputStream(uploadPicPath);
            fos.write(picContent);
            fos.flush();
            fos.close(); // 后开先关

            //写到工程
            fos = new FileOutputStream("E:\\project\\java\\graduationPro\\src\\main\\resources\\static\\pic\\copyPic\\" + name);
            fos.write(picContent);
            fos.flush();
            // 关闭流  先开后关  后开先关
            fos.close(); // 后开先关
        } catch (Exception e) {
            System.out.println();
            return null;
        }
        return name;
    }
}
