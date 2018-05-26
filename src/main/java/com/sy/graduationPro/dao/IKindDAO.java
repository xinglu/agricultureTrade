package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.Kind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "kindDAO")
public interface IKindDAO extends JpaRepository<Kind, Integer> {

    @Query("select k from Kind k where k.hasDel=0")
    List<Kind> fetchAll();
}
