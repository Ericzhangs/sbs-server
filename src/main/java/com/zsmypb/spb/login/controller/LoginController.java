package com.zsmypb.spb.login.controller;

import com.zsmypb.spb.base.constants.Result;
import com.zsmypb.spb.base.redis.RedisUtil;
import com.zsmypb.spb.hello.service.HelloService;
import com.zsmypb.spb.login.domain.LoginParam;
import com.zsmypb.spb.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    LoginService loginService;
    @Autowired
    private HelloService helloService;

    @RequestMapping("/in")
    public Result loginIn(@RequestBody LoginParam loginParam) {
        UsernamePasswordToken loginToken = new UsernamePasswordToken(loginParam.getUserName(), loginParam.getPassword(), loginParam.getRememberMe());
        Subject currentUser = SecurityUtils.getSubject();

        try {
            currentUser.login(loginToken);
        } catch (UnknownAccountException e) {
            return Result.fail(e.getMessage());
        }
//        Object principal = currentUser.getPrincipal();
//        redisUtil.set("principal", principal);
        return Result.ok("登录成功");
    }

    @RequestMapping("/out")
    public Result loginOut() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return Result.ok("登录成功");
    }
}
