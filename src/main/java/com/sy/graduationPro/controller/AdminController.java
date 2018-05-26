package com.sy.graduationPro.controller;

import com.sy.graduationPro.common.response.ResponseMsg;
import com.sy.graduationPro.service.impl.AdminInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunguiyong on 2018/5/24.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminInit adminInit;

    @GetMapping("/init")
    @ResponseBody
    public ResponseMsg init() {
        adminInit.setInfo();
        return ResponseMsg.success();
    }
}
