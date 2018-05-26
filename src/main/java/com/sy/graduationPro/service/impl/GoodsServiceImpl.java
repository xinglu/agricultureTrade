package com.sy.graduationPro.service.impl;

import com.sy.graduationPro.bean.Goods;
import com.sy.graduationPro.bean.Kind;
import com.sy.graduationPro.dao.IGoodsDAO;
import com.sy.graduationPro.dao.IKindDAO;
import com.sy.graduationPro.service.IGoodsService;
import com.sy.graduationPro.vo.GoodsKindVO;
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

    private List<GoodsKindVO> goodsKindList = new ArrayList<>();

    @Override
    public List<GoodsKindVO> getGoodsAndKind() {
        List<Kind> kindList = kindDAO.fetchAll();
        for (Kind item : kindList) {
            List<String> goodsNameList = goodsDAO.fetchByUUid(item.getUid());
            GoodsKindVO goodsKindVO = new GoodsKindVO(item.getName(), goodsNameList);
            goodsKindList.add(goodsKindVO);
        }
        if(null == goodsKindList){
            return new ArrayList<>(goodsKindList);
        }
        return goodsKindList;
    }
}
