package com.zsmypb.sbs.base.shiro;

import com.zsmypb.sbs.login.domain.User;
import com.zsmypb.sbs.login.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("授权");
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        User user = loginService.findUserByName(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for (Role role:user.getRoles()) {
//            //添加角色
//            simpleAuthorizationInfo.addRole(role.getRoleName());
//            for (Permission permission:role.getPermissions()) {
//                //添加权限
//                simpleAuthorizationInfo.addStringPermission(permission.getPermission());
//            }
//        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("信息验证");
        if (authenticationToken.getPrincipal() == null) {
            throw new UnknownAccountException("没有登录");
        }
        //获取用户信息
        String userName = (String) authenticationToken.getPrincipal();
//        String passWord = (String)authenticationToken.getCredentials();
        log.info("authenticationToken.userName()----: {}", authenticationToken.getCredentials());
        String passWord = String.valueOf((char[]) authenticationToken.getCredentials());
//        LoginParam loginParam = (LoginParam)authenticationToken.getPrincipal();

        log.info("authenticationToken.passWord()----: {}", passWord);
//        User user = loginService.findUserByName(loginParam.getUserName());
        User user = loginService.findUserByName(userName);
        log.info("user {}", user);
        if (user == null || !user.getPassword().equals(passWord)) {
            //这里返回后会报出对应异常 throw
            throw new UnknownAccountException("没有该用户");
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, user.getPassword(), getName());
            return simpleAuthenticationInfo;
        }
    }
}
