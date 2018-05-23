package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "goodsDAO")
public interface IGoodsDAO extends JpaRepository<Goods, Integer>{
}
