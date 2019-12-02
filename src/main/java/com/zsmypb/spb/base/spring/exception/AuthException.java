package com.zsmypb.spb.base.spring.exception;

/**
 * @author zhangs.
 * @date 2019/11/11.
 */
public class AuthException extends RuntimeException {

    private static String massage;

    public AuthException(String message) {
        super(message);
    }
}
