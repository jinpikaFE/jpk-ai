package com.jpk.jpkai.common.exception;

import cn.hutool.json.JSONObject;
import com.jpk.jpkai.common.api.CommonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<CommonResult<JSONObject>> handle(ApiException e) {
        if (e.getErrorCode() != null && e.getMessage() != null) {
            return CommonResult.codeFailed(e.getErrorCode(), e.getMessage());
        }
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResult<JSONObject>> handleValidException(MethodArgumentNotValidException e) {
        return getCommonResultResponseEntity(e);
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public ResponseEntity<CommonResult<JSONObject>> handleValidException(BindException e) {
        return getCommonResultResponseEntity(e);
    }

    private ResponseEntity<CommonResult<JSONObject>> getCommonResultResponseEntity(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField() + fieldError.getDefaultMessage();
            }
        }
        return CommonResult.validateFailed(message);
    }
}
