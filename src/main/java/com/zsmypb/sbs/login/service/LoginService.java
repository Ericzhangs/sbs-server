package com.zsmypb.sbs.login.service;

import com.zsmypb.sbs.login.domain.User;
import com.zsmypb.sbs.login.mapper.LoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
