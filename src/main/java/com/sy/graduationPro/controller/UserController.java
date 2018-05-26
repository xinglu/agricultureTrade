package com.sy.graduationPro.controller;

import com.sy.graduationPro.common.response.ResponseMsg;
import com.sy.graduationPro.service.IUserService;
import com.sy.graduationPro.common.util.StrUtil;
import com.sy.graduationPro.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunguiyong on 2018/5/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //用户注册
    @ResponseBody
    @GetMapping("/register")
    public ResponseMsg userRegister(Integer auth, String name, String password, String address, String realName,
                                    String gender, String phone, String email) {
        if (StrUtil.isEmpty(name, password, address, realName, gender, phone, email) || auth == null) {
            return ResponseMsg.fail();
        }

        //存储到数据库
        String res = userService.saveUser(auth, name, password, address, realName, gender, phone, email);
        if ("注册成功".equals(res)) {
            return ResponseMsg.fail(res);
        }
        return ResponseMsg.success(res);
    }

    //用户登录
    @ResponseBody
    @GetMapping("/login")
    public ResponseMsg userLogin(String loginName, String password) {

        if (StrUtil.isEmpty(loginName, password)) {
            return ResponseMsg.fail();
        }

        //用户登录动作
        UserVO res = userService.userLogin(loginName, password);
        if (null == res) {
            return ResponseMsg.fail("登录失败");
        }
        return ResponseMsg.success(res);
    }

    //查看用户信息
    @ResponseBody
    @GetMapping("/look")
    public ResponseMsg lookUserInfo(String userName) {

        if (StrUtil.isEmpty(userName)) {
            return ResponseMsg.fail("用户名不可为空");
        }

        UserVO user = userService.lookUserInfo(userName);
        if (user == null) {
            return ResponseMsg.fail("查询用户信息失败");
        }
        return ResponseMsg.success(user);
    }

    //修改用户信息
    @ResponseBody
    @GetMapping("/change")
    public ResponseMsg changeUserInfo() {

        return ResponseMsg.success();
    }
}
