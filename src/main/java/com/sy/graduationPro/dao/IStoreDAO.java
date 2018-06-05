package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "storeDAO")
public interface IStoreDAO extends JpaRepository<Store, Integer> {

    @Query("select s from Store s where s.name=:name and s.hasCancel = 0")
    Store findByName(@Param("name") String name);

    @Query("select s from Store s where s.sellerId=:uId and s.hasCancel = 0")
    Store findBySellerId(@Param("uId") Integer userId);

    @Query("select s.name from Store s where s.sellerId = :uId and s.hasCancel=0")
    String findStoreName(@Param("uId") Integer userId);
}
