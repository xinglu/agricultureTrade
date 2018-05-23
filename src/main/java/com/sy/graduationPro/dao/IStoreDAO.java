package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "storeDAO")
public interface IStoreDAO extends JpaRepository<Store, Integer> {
}
