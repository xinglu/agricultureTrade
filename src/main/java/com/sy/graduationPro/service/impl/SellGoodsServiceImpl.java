package com.sy.graduationPro.service.impl;

import com.sy.graduationPro.bean.Goods;
import com.sy.graduationPro.bean.SellGoods;
import com.sy.graduationPro.bean.Store;
import com.sy.graduationPro.bean.User;
import com.sy.graduationPro.dao.IGoodsDAO;
import com.sy.graduationPro.dao.ISellGoodsDAO;
import com.sy.graduationPro.dao.IStoreDAO;
import com.sy.graduationPro.dao.IUserDAO;
import com.sy.graduationPro.service.ISellGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.OutputStream;

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

    private String uploadPicPath = "../webapps/agriculture/WEB-INF/classes/static/pic/copyPic/";

    @Override
    public String addSellGoods(String sellName, String userName, String goodsName,
                               String picPath, Float price, Integer quantity) {

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
        if(exists != null){
            return "当前店铺已有此类产品";
        }

        SellGoods sellGoods = new SellGoods(sellName, store.getId(), goods.getId(),
                price, quantity, picPath);
        sellGoodsDAO.save(sellGoods);
        return "添加商品成功";
    }

    @Override
    public String uploadPic(String picName, byte[] picContent) {
        String name = copyPicture(picName, picContent);
        return "http://localhost:8080/agriculture/pic/copyPic/" + name;
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
            fos = new FileOutputStream("E:\\project\\java\\graduationPro\\src\\main\\resources\\static\\pic\\copyPic\\"+name);
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
