package com.zsmypb.sbs.base.shiro.filter;

import org.apache.shiro.web.servlet.AdviceFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author zhangs.
 * @date 2019/11/11.
 */
@Component
public class myAdviceFilterTest extends AdviceFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
//        System.out.println("====  myAdviceFilterTest  预处理/前置处理");
//        if (!SecurityUtils.getSubject().isAuthenticated()) {
//            HttpServletResponse res = (HttpServletResponse)response;
//            res.sendError(403, "未登录");
//            return false;
//        }
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
