package com.jpk.jpkai.common.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 通用返回对象
 * Created by macro on 2019/4/19.
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseEntity<CommonResult<T>> success(T data) {
        CommonResult<T> result = new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
        return ResponseEntity.ok(result);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> ResponseEntity<CommonResult<T>> success(T data, String message) {
        CommonResult<T> result = new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
        return ResponseEntity.ok(result);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> ResponseEntity<CommonResult<T>> failed(IErrorCode errorCode) {
        CommonResult<T> result = new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> ResponseEntity<CommonResult<T>> failed(IErrorCode errorCode, String message) {
        CommonResult<T> result = new CommonResult<>(errorCode.getCode(), message, null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResponseEntity<CommonResult<T>> failed(String message) {
        CommonResult<T> result = new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResponseEntity<CommonResult<T>> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     */
    public static <T> ResponseEntity<CommonResult<T>> codeFailed(IErrorCode errorCode, String message) {
        CommonResult<T> result = new CommonResult<>(errorCode.getCode(), message, null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResponseEntity<CommonResult<T>> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResponseEntity<CommonResult<T>> validateFailed(String message) {
        CommonResult<T> result = new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResponseEntity<CommonResult<T>> unauthorized(T data) {
        CommonResult<T> result = new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResponseEntity<CommonResult<T>> forbidden(T data) {
        CommonResult<T> result = new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
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
}
