package com.learn.common.exception;

/**
 * 自定义异常
 */
public class CommonException extends RuntimeException {

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

}
