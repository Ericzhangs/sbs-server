package com.zsmypb.sbs.base.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * AOP 处理请求日志
 */
@Aspect
@Component
@Slf4j
public class LogAspect  {

    @Pointcut("execution(public * com.zsmypb.sbs.*.controller.*.*(..)) || execution(public * com.zsmypb.sbs.manage.*.controller.*.*(..))")
//    @Pointcut("execution(public * com.zsmypb.spb..controller.*(..))")
    public void recordLog(){}


    /**
     * 使用AOP前置通知拦截请求参数信息
     * @param joinPoint
     */
    @Before("recordLog()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("请求进入");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            log.info("name:{},value:{}", name, request.getParameter(name));
        }
    }

    /**
     * 后置通知
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "recordLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("请求完成 RESPONSE : " + ret);
    }
}
