package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "orderDAO")
public interface IOrderDAO extends JpaRepository<Order, Integer>{
}
