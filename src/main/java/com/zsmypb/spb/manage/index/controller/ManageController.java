package com.zsmypb.spb.manage.index.controller;

import com.zsmypb.spb.base.constants.Result;
import com.zsmypb.spb.base.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    RedisUtil  redisUtil;

    @RequestMapping("/index")
    public Result index() {
        Object principal = redisUtil.get("principal");
        return Result.ok("主页", principal);
    }
}
