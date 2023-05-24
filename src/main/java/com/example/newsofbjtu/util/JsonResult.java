package com.example.newsofbjtu.util;

public class JsonResult <T>{
    // 返回数据
    private T resData;
    // 返回状态码
    private String code;
    // 返回提示消息
    private String msg;

    /**
     * 若没有数据返回，默认状态码为0，提示信息为：操作成功！
     */
    public JsonResult() {
        this.code = "1";
        this.msg = "操作成功！";
    }
    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回时，状态码为1，默认提示信息为：操作成功！
     */
    public JsonResult(T resData) {
        this.resData = resData;
        this.code = "1";
        this.msg = "操作成功！";
    }

    /**
     * 有数据返回，状态码为1，人为指定提示信息
     */
    public JsonResult(T resData, String msg) {
        this.resData = resData;
        this.code = "1";
        this.msg = msg;
    }

    public T getData() {
        return resData;
    }

    public void setData(T resData) {
        this.resData = resData;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "resData=" + resData +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
