package com.sy.graduationPro.common.response;

/**
 * Created by sunguiyong on 2018/5/17.
 */
public enum ResponseEnum {
    SUCCESS(200, "成功"),
    PARA_ERROR(402, "参数错误"),
    FAIL(500, "服务器错误");

    private int code;
    private String desc;

    ResponseEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
