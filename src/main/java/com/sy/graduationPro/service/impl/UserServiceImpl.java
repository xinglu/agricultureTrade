package com.sy.graduationPro.service.impl;

import com.sy.graduationPro.bean.User;
import com.sy.graduationPro.dao.IAuthorityDAO;
import com.sy.graduationPro.dao.IUserDAO;
import com.sy.graduationPro.service.IUserService;
import com.sy.graduationPro.common.util.Encrypt;
import com.sy.graduationPro.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunguiyong on 2018/5/16.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private IAuthorityDAO authorityDAO;

    @Override
    public String saveUser(Integer auth, String name, String password, String address, String realName, String
            gender, String phone, String email) {
        //判断权限是否在系统中
        List<Integer> authList = authorityDAO.findAllIdentifier();
        if (!authList.contains(auth)) {
            return "系统中无此权限";
        }
        //判断当前用户是否存在
        List<User> existList = userDAO.findByNameOrPhone(name, phone);
        if (!existList.isEmpty()) {
            return "用户名或手机号已在系统中";
        }
        password = Encrypt.encrypt(password);
        User user = new User(auth, name, password, address, realName, gender, phone, email);
        userDAO.save(user);
        return "注册成功";
    }

    @Override
    public UserVO userLogin(String logInfo, String password) {

        //根据账号查询无用户或查出多个，登录失败
        List<User> userList = userDAO.findByNameOrPhone(logInfo, logInfo);
        if (userList.isEmpty() || userList.size() > 1) {
            return null;
        }
        password = Encrypt.encrypt(password);
        User user = userDAO.userLogin(logInfo, password);
        if (null == user) {
            return null;
        }
        return new UserVO(user);
    }

    @Override
    public UserVO lookUserInfo(String userName) {
        User user = userDAO.findByName(userName);
        if (user == null) {
            return null;
        }
        return new UserVO(user);
    }

    @Override
    public boolean changeUserInfo(String name, String phone, String address, String email) {

        List<User> userList = userDAO.findByNameOrPhone(name, phone);
        if (userList.isEmpty()) {
            return false;
        }
        userDAO.updateUserInfo(name, address, email);
        return true;
    }
}
