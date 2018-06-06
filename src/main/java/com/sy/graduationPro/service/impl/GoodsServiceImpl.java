package com.sy.graduationPro.service.impl;

import com.sun.org.apache.bcel.internal.generic.ISTORE;
import com.sy.graduationPro.bean.*;
import com.sy.graduationPro.dao.*;
import com.sy.graduationPro.service.IGoodsService;
import com.sy.graduationPro.vo.GoodsKindVO;
import com.sy.graduationPro.vo.GoodsSellVO;
import com.sy.graduationPro.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sunguiyong on 2018/5/24.
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private IKindDAO kindDAO;
    @Autowired
    private IGoodsDAO goodsDAO;
    @Autowired
    private IStoreDAO storeDAO;
    @Autowired
    private IUserDAO userDAO;

    private List<GoodsKindVO> goodsKindList;

    @Override
    public List<GoodsKindVO> getGoodsAndKind() {
        goodsKindList = new ArrayList<>();
        List<Kind> kindList = kindDAO.fetchAll();
        for (Kind item : kindList) {
            List<String> goodsNameList = goodsDAO.fetchByUUid(item.getUid());
            GoodsKindVO goodsKindVO = new GoodsKindVO(item.getName(), goodsNameList);
            goodsKindList.add(goodsKindVO);
        }
        if (null == goodsKindList) {
            return new ArrayList<>(goodsKindList);
        }
        return goodsKindList;
    }

    @Override
    public String getStoreName(String userName) {
        User user = userDAO.findByName(userName);
        if (user == null) {
            return "当前用户不存在";
        }
        String storeName = storeDAO.findStoreName(user.getId());
        if(storeName == null){
            return "当前用户没有店铺";
        }
        return storeName;
    }

    @Override
    public List<GoodsVO> getAllGoods() {
        List<Goods> goodsList = goodsDAO.getAllGoods();
        List<GoodsVO> resVO = new ArrayList<>();
        for (Goods item : goodsList) {
            GoodsVO vo = new GoodsVO(item);
            resVO.add(vo);
        }
        return resVO;
    }
}
