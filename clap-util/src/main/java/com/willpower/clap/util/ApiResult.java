package com.willpower.clap.util;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Powersoft on 2019/4/8.
 */
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int CODE_SUCCESS = 200;

    private static final int CODE_FAIL = 400;

    private static final String MSG_SUCCESS = "success";
    private static final String MSG_FAIL = "failed";

    /**
     * 返回状态码
     */
    private int status;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回内容
     */
    private T data;

    /**
     * 分页信息
     */
    private PageInfo pageInfo;

    /**
     * 其他内容
     */
    private Map<String, Object> ext;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ApiResult() {
        this.status = CODE_SUCCESS;
        this.message = MSG_SUCCESS;
    }

    public ApiResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResult(int status, String message, T data, Map<String, Object> ext) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
    }

    public ApiResult(int status, String message, T data, PageInfo pageInfo) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public ApiResult(int status, String message, T data, Map<String, Object> ext, PageInfo pageInfo) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
        this.pageInfo = pageInfo;
    }

    public ApiResult(int status, String message, T data, Long total, Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        this.status = status;
        this.message = message;
        this.data = data;
        this.pageInfo = pageInfo;
    }

    public ApiResult(int status, String message, T data, Map<String, Object> ext, Long total, Integer pageNo,
            Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        this.status = status;
        this.message = message;
        this.data = data;
        this.ext = ext;
        this.pageInfo = pageInfo;
    }

    //快速返回成功
    public static <T> ApiResult success() {
        return new ApiResult<T>(CODE_SUCCESS, "请求成功", null);
    }

    public static <T> ApiResult success(T result, PageInfo pageInfo) {
        return new ApiResult<T>(CODE_SUCCESS, "请求成功", result);
    }

    public static <T> ApiResult success(T result) {
        return new ApiResult<T>(CODE_SUCCESS, "请求成功", result);
    }

    public static <T> ApiResult success(String message, T result) {
        return new ApiResult<T>(CODE_SUCCESS, message, result);
    }

    public static <T> ApiResult success(String message, T result, Map<String, Object> extra) {
        return new ApiResult<T>(CODE_SUCCESS, message, result, extra);
    }

    public static <T> ApiResult success(T result, Long total, Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ApiResult<T>(CODE_SUCCESS, "请求成功", result, pageInfo);
    }

    public static <T> ApiResult success(T result, Map<String, Object> extra, Long total, Integer pageNo,
            Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ApiResult<T>(CODE_SUCCESS, "请求成功", result, extra, pageInfo);
    }

    public static <T> ApiResult success(String message, T result, Long total, Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ApiResult<T>(CODE_SUCCESS, message, result, pageInfo);
    }

    public static <T> ApiResult success(String message, T result, Map<String, Object> extra, Long total, Integer pageNo,
            Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ApiResult<T>(CODE_SUCCESS, message, result, extra, pageInfo);
    }

    //快速返回失败状态
    public static <T> ApiResult fail() {
        return new ApiResult<T>(ErrorCode.SERVER_ERROR.getCode(), ErrorCode.SERVER_ERROR.getMessage());
    }

    public static <T> ApiResult fail(T result) {
        return new ApiResult<T>(ErrorCode.SERVER_ERROR.getCode(), ErrorCode.SERVER_ERROR.getMessage(), result);
    }

    public <T> ApiResult fail(String message, T result) {
        return new ApiResult<T>(ErrorCode.SERVER_ERROR.getCode(), message, result);
    }

    public <T> ApiResult fail(String message, T result, Map<String, Object> extra) {
        return new ApiResult<T>(ErrorCode.SERVER_ERROR.getCode(), message, result, extra);
    }

    public static <T> ApiResult fail(ErrorCode errorCode) {
        return new ApiResult<T>(errorCode.getCode(), errorCode.getMessage());
    }

    public static <T> ApiResult fail(ErrorCode errorCode, T result) {
        return new ApiResult<T>(errorCode.getCode(), errorCode.getMessage(), result);
    }

    public static <T> ApiResult fail(ErrorCode errorCode, String message, T result) {
        return new ApiResult<T>(errorCode.getCode(), message, result);
    }

    public static <T> ApiResult fail(ErrorCode errorCode, String message, T result, Map<String, Object> extra) {
        return new ApiResult<T>(errorCode.getCode(), message, result, extra);
    }

    //快速返回自定义状态码
    public static <T> ApiResult result(int statusCode, String message) {
        return new ApiResult<T>(statusCode, message);
    }

    public static <T> ApiResult result(int statusCode, String message, T result) {
        return new ApiResult<T>(statusCode, message, result);
    }

    public static <T> ApiResult result(int statusCode, String message, T result, Map<String, Object> extra) {
        return new ApiResult<T>(statusCode, message, result, extra);
    }

    public static <T> ApiResult result(int statusCode, String message, T result, Long total, Integer pageNo,
            Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ApiResult<T>(statusCode, message, result, pageInfo);
    }

    public static <T> ApiResult result(int statusCode, String message, T result, Map<String, Object> extra, Long total,
            Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return new ApiResult<T>(statusCode, message, result, extra, pageInfo);
    }

    //快速返回Http状态
    public static <T> ApiResult httpStatus(HttpStatus httpStatus, String message) {
        return result(Integer.parseInt(httpStatus.toString()), message);
    }

    public static <T> ApiResult httpStatus(HttpStatus httpStatus, String message, T result) {
        return result(Integer.parseInt(httpStatus.toString()), message, result);
    }

    public static <T> ApiResult httpStatus(HttpStatus httpStatus, String message, T result, Map<String, Object> extra) {
        return result(Integer.parseInt(httpStatus.toString()), message, result, extra);
    }

    public static <T> ApiResult httpStatus(HttpStatus httpStatus, String message, T result, Long total, Integer pageNo,
            Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return result(Integer.parseInt(httpStatus.toString()), message, result, total, pageNo, pageSize);
    }

    public static <T> ApiResult httpStatus(HttpStatus httpStatus, String message, T result, Map<String, Object> extra,
            Long total, Integer pageNo, Integer pageSize) {
        PageInfo pageInfo = new PageInfo(total, pageNo, pageSize);
        return result(Integer.parseInt(httpStatus.toString()), message, result, extra, total, pageNo, pageSize);
    }

}
