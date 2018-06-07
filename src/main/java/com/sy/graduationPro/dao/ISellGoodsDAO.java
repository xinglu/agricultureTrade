package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.SellGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "sellGoodsDAO")
public interface ISellGoodsDAO extends JpaRepository<SellGoods, Integer> {

    @Query("select sg from SellGoods sg where sg.storeId=:storeId and sg.hasCancel = 0 order by sg.addTime desc")
    List<SellGoods> getGoodsListOfStore(@Param("storeId")Integer storeId);

    @Query("select sg from SellGoods sg where sg.storeId=:stId and sg.goodsId=:gId and sg.hasCancel = 0")
    SellGoods fetchByStoreAndGoodsId(@Param("stId") Integer storeId, @Param("gId") Integer goodsId);

    @Query(value = "select * from sell_goods where goods_id in :gId and has_cancel = 0", nativeQuery = true)
    List<SellGoods> fetchByGoodsId(@Param("gId") List<Integer> goodsId);

    @Query("update SellGoods sg set sg.sellNum=:sellNum where sg.id=:id and sg.hasCancel = 0")
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    void addSellNum(@Param("sellNum")String sellNum, @Param("id")Integer id);
}
