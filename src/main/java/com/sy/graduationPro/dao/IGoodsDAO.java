package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "goodsDAO")
public interface IGoodsDAO extends JpaRepository<Goods, Integer> {

    @Query("select g.name from Goods g where g.kindUid=:uid and g.hasDel = 0")
    List<String> fetchByUUid(@Param("uid") String uid);
}
