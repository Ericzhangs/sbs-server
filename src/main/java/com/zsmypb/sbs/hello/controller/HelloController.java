package com.zsmypb.sbs.hello.controller;

import com.github.bingoohuang.westid.WestId;
import com.zsmypb.sbs.hello.domain.Hello;
import com.zsmypb.sbs.hello.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("world")
    public String world(){
        return "Hi world";
    }

    @RequestMapping("data-world")
    public Hello dataWorld() {
        return Hello.builder()
                .id(String.valueOf(WestId.next()))
                .hello("Hello")
                .world("World").build();
    }

    @RequestMapping("world-list")
    public List<Hello> getWorldList() {
        List<Hello> helloList = helloService.getHelloList();
        log.info("getWorldListgetWorldList ======  {}", helloList);
        return helloList;
    }
}
