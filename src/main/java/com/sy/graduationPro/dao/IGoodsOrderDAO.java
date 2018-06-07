package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.GoodsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "goodsOrderDAO")
public interface IGoodsOrderDAO extends JpaRepository<GoodsOrder, Integer>{

    @Query("select og from GoodsOrder og where og.buyerId=:buyerId")
    List<GoodsOrder> findByBuyerId(@Param("buyerId")Integer buyerId);
}
