package com.willpower.clap.util;

/**
 * Created by Powersoft on 2019/4/8.
 */
public enum ErrorCode {

    SUCCESS(200, "success"),
    NO_PERMISSION(211, "权限不足"),
    SERVER_ERROR(10000, "服务器异常"),
    AUTH_ERROR(10001, "认证失败"),
    AUTH_PASSWORD_ERROR(10002, "密码错误"),
    AUTH_USER_LOCK(10003, "用户锁定"),
    AUTH_USER_NOTFOUND(10004, "用户不存在"),
    AUTH_LOGIN_FAIL(10005, "登录失败"),
    PARAMS_ERROR(100101, "参数错误"),
    JSON_PARSE_ERROR(100102, "Json解析错误"),
    ILLEAGAL_STRING(15001, "非法字符串"),
    UNKNOW_ERROR(16000, "未知错误");



    private int code;

    private String message;


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static void main(String[] args) {
        System.out.println(ErrorCode.SERVER_ERROR.getMessage());
    }

}
