package com.zsmypb.spb.base.spring.exception;

import com.zsmypb.spb.base.constants.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.zsmypb.spb.base.constants.Result.*;

/**
 * @author zhangs.
 * @date 2019/11/11.
 */
@Slf4j
@RestControllerAdvice
@Repository
public class GlobalExceptionHandler {


    @ExceptionHandler({UnknownAccountException.class})
    public Result handleThrowable(UnknownAccountException e) {
        log.error("error:" + e.getMessage(), e);
        return new Result(RSPCODE_UNKNOWNACCOUNT, "未知用户");
    }

    @ExceptionHandler({UnauthenticatedException.class})
    public Result handleThrowable(UnauthenticatedException e) {
        log.error("error:" + e.getMessage(), e);
        return new Result(RSPCODE_UNAUTHENTICATED, "未认证");
    }

    @ExceptionHandler({UnavailableSecurityManagerException.class})
    public Result handleThrowable(UnavailableSecurityManagerException e) {
        log.error("error:" + e.getMessage(), e);
        return new Result(RSPCODE_UNAUTHENTICATED, "未认证");
    }

    @ExceptionHandler({AuthorizationException.class, AuthenticationException.class})
    public Result handleThrowable(AuthorizationException e) {
        log.error("error:" + e.getMessage(), e);
        return new Result(RSPCODE_AUTHORIZATION, "权限未通过");
    }

    @ExceptionHandler({AuthException.class})
    public Result authException(AuthException e) {
        log.error("error:" + e.getMessage(), e);
        return new Result(RSPCODE_UNAUTHENTICATED, e.getMessage());
    }
}
