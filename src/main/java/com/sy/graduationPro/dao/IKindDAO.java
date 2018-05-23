package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "kindDAO")
public interface IKindDAO extends JpaRepository<Kind, Integer> {
}
