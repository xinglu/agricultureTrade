package com.sy.graduationPro.service;

import com.sy.graduationPro.vo.UserVO;
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
    UserVO userLogin(String logInfo, String password);

    //查询用户信息
    UserVO lookUserInfo(String userName);

    //更改用户信息
    boolean changeUserInfo(String name, String phone, String address, String email);
}
