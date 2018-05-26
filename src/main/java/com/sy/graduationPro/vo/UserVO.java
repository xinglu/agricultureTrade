package com.sy.graduationPro.vo;

import com.sy.graduationPro.bean.User;

/**
 * Created by sunguiyong on 2018/5/26.
 */
public class UserVO {

    private String userName;
    private String phone;
    private String address;
    private String email;

    private Integer auth;

    public UserVO(User user) {
        this.userName = user.getName();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.email = user.getEmail();
        this.auth = user.getAuthority();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAuth() {
        return auth;
    }

    public void setAuth(Integer auth) {
        this.auth = auth;
    }
}
