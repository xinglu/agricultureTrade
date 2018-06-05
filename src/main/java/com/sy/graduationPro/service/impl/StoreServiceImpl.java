package com.sy.graduationPro.service.impl;

import com.sy.graduationPro.bean.*;
import com.sy.graduationPro.dao.*;
import com.sy.graduationPro.service.IStoreService;
import com.sy.graduationPro.vo.GoodsSellVO;
import com.sy.graduationPro.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2018/6/5.
 */
@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private IStoreDAO storeDAO;
    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private IKindDAO kindDAO;
    @Autowired
    private ISellGoodsDAO sellGoodsDAO;
    @Autowired
    private IGoodsDAO goodsDAO;

    @Override
    public List<GoodsSellVO> getGoodsOfStore(String userName) {
        User user = userDAO.findByName(userName);
        if (user == null) {
            return null;
        }
        Store store = storeDAO.findBySellerId(user.getId());
        if (store == null) {
            return null;
        }

        List<SellGoods> resList = sellGoodsDAO.getGoodsListOfStore(store.getId());

        return beanToVO(resList);
    }

    @Override
    public String storeRegister(String userName, String name, String address) {

        User user = userDAO.findByName(userName);
        if (user == null) {
            return "当前用户不存在";
        }

        Store store = storeDAO.findBySellerId(user.getId());
        if (store != null) {
            return "此店铺名称已被注册";
        }

        Store addStore = new Store(user.getId(), name, address);
        storeDAO.save(addStore);

        return "开通店铺成功";
    }

    @Override
    public List<GoodsSellVO> getGoodsByCon(String kindName, String goodsName) {

        Kind kind;
        List<Integer> goodsId = new ArrayList<>();
        Goods goods;
        if (!"".equals(kindName)) {
            kind = kindDAO.findByName(kindName);
            goodsId = goodsDAO.fetchGoodsIdByUUid(kind.getUid());
        }
        if (!"".equals(goodsName)) {
            goods = goodsDAO.findByGoodsName(goodsName);
            goodsId.add(goods.getId());
        }
        List<SellGoods> goodsList = sellGoodsDAO.fetchByGoodsId(goodsId);

        return beanToVO(goodsList);
    }

    private List<GoodsSellVO> beanToVO(List<SellGoods> list) {
        List<GoodsSellVO> res = new ArrayList<>();

        for (SellGoods item : list) {
            GoodsSellVO vo = new GoodsSellVO(item);
            Goods goods = goodsDAO.findById(item.getGoodsId());
            vo.setGoodsName(goods.getName());
            res.add(vo);
        }
        return res;
    }
}
