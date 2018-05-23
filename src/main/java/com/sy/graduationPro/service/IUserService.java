package com.sy.graduationPro.service;

import org.springframework.stereotype.Service;

/**
 * Created by sunguiyong on 2018/5/15.
 */
@Service(value = "userService")
public interface IUserService {

    //保存用户到数据库
    String saveUser(Integer auth, String name, String password, String address, String realName,
                     String gender, String phone, String email);

    //用户登录
    boolean userLogin(String logInfo, String password);

}
