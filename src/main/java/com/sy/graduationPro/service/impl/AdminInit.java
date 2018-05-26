package com.sy.graduationPro.service.impl;

import com.sy.graduationPro.bean.Goods;
import com.sy.graduationPro.bean.Kind;
import com.sy.graduationPro.common.constant.BaseConstant;
import com.sy.graduationPro.common.util.StrUtil;
import com.sy.graduationPro.dao.IGoodsDAO;
import com.sy.graduationPro.dao.IKindDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

/**
 * Created by sunguiyong on 2018/5/24.
 */
@Service
public class AdminInit {

    @Autowired
    private IKindDAO kindDAO;
    @Autowired
    private IGoodsDAO goodsDAO;

    @Transactional(rollbackFor = Exception.class)
    public void setInfo() {
        Set<String> keys = BaseConstant.goodMap.keySet();
        String uuid;
        for (String key : keys) {
            uuid = StrUtil.uuid();
            Kind kind = new Kind(key, uuid);
            kindDAO.save(kind);
            Collection<String> values = BaseConstant.goodMap.get(key);
            for (String value : values) {
                Goods goods = new Goods(value, uuid);
                goodsDAO.save(goods);
            }
        }
    }
}
