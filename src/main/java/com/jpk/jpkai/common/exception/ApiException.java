package com.jpk.jpkai.common.exception;

import com.jpk.jpkai.common.api.IErrorCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiException extends RuntimeException {
    private final IErrorCode errorCode;

    public ApiException(String message) {
        super(message);
        this.errorCode = null;
    }

    public ApiException(Throwable cause) {
        super(cause);
        this.errorCode = null;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = null;
    }

    public ApiException(IErrorCode errorCode, String message) {
        this(errorCode, message, null);
    }

    public ApiException(IErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public static ApiException from(Throwable cause) {
        return new ApiException(cause.getMessage(), cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}