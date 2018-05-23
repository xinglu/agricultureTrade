package com.sy.graduationPro.dao;

import com.sy.graduationPro.bean.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Repository(value = "authorityDAO")
public interface IAuthorityDAO extends JpaRepository<Authority, Integer> {

    @Query("select auth.identifier from Authority auth")
    List<Integer> findAllIdentifier();
}
