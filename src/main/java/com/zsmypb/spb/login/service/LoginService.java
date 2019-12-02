package com.zsmypb.spb.login.service;

import com.zsmypb.spb.hello.domain.Hello;
import com.zsmypb.spb.login.domain.User;
import com.zsmypb.spb.login.mapper.LoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public User findUserByName(String name) {
        log.info("findUserByName+++++  {}",  name);
        return loginMapper.getUserByName(name);
    }
}
