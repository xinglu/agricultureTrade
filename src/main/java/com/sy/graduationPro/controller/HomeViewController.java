package com.sy.graduationPro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sunguiyong on 2018/5/15.
 */
//@RequestMapping("/login")
@Controller
public class HomeViewController {

//    @ResponseBody
//    @GetMapping("/index")
//    public String login(){
//        return "index";
//    }

    @RequestMapping("/index")  //必须
    public String login2(){
        return "home";
    }
}
