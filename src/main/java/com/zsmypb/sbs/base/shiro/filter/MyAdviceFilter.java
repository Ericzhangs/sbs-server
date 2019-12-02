package com.zsmypb.sbs.base.shiro.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangs.
 * @date 2019/11/11.
 */
@Slf4j
@Component
public class MyAdviceFilter extends AdviceFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        log.info("MyAdviceFilter====预处理/前置处理");
        HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        log.info(requestURI);
        Subject subject = SecurityUtils.getSubject();
        log.info("是否记住我=== {}", subject.isRemembered());
        log.info("当前登陆人=== {}", subject.getPrincipal());
        log.info("是否已经登陆=== {}", subject.isAuthenticated());
        if (subject.isRemembered()) return true;
        if (requestURI.contains("login")) return true;
        if (!subject.isAuthenticated()) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendError(403, "未登录");
            return false;
        }
        return true;//返回 false 将中断后续拦截器链的执行
    }

    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
//        System.out.println("====后处理/后置返回处理");
    }

    @Override
    public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception) throws
            Exception {
//        System.out.println("====完成处理/后置最终处理");
    }
}
