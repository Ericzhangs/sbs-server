package com.zsmypb.sbs;

import com.zsmypb.sbs.base.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbApplicationTests {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void contextLoads() {
    }

    @Test
    public void setTest() {
        boolean set = redisUtil.set("sss", "aaaa");
        System.out.println("=====" + set);
    }

    @Test
    public void getTest() {
        Object sss = redisUtil.get("sss");
        System.out.println("-----" + sss);
    }

}
