package com.sy.graduationPro.common.response;

/**
 * Created by sunguiyong on 2018/5/17.
 */
public class ResponseMsg {
    private Integer code;
    private Object data;
    private OtherInfo other;

    public static ResponseMsg success() {
        return new ResponseMsg(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc(), null);
    }

    public static ResponseMsg success(Object data) {
        return new ResponseMsg(ResponseEnum.SUCCESS.getCode(), data, null);
    }

    public static ResponseMsg success(Object data, OtherInfo other) {
        return new ResponseMsg(ResponseEnum.SUCCESS.getCode(), data, other);
    }

    public static ResponseMsg paragramError() {
        return new ResponseMsg(ResponseEnum.PARA_ERROR.getCode(), ResponseEnum.PARA_ERROR.getDesc(), null);
    }

    public static ResponseMsg paragramError(Object data) {
        return new ResponseMsg(ResponseEnum.PARA_ERROR.getCode(), data, null);
    }

    public static ResponseMsg fail() {
        return new ResponseMsg(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getDesc(), null);
    }

    public static ResponseMsg fail(Object data) {
        return new ResponseMsg(ResponseEnum.FAIL.getCode(), data, null);
    }


    ResponseMsg(int code, Object data, OtherInfo other) {
        this.code = code;
        this.data = data;
        this.other = other;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public OtherInfo getOther() {
        return other;
    }

    public void setOther(OtherInfo other) {
        this.other = other;
    }
}
