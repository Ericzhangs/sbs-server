package com.zsmypb.sbs.hello.service.impl;

import com.zsmypb.sbs.hello.domain.Hello;
import com.zsmypb.sbs.hello.mapper.HelloMapper;
import com.zsmypb.sbs.hello.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Override
    public List<Hello> getHelloList() {
        List<Hello> helloList = helloMapper.getHelloList();
        return helloList;
    }
}
