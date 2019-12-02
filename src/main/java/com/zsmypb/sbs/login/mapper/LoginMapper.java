package com.zsmypb.sbs.login.mapper;

import com.zsmypb.sbs.hello.domain.Hello;
import com.zsmypb.sbs.login.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {

    List<Hello> getHelloList();
    User getUserByName(String name);
}
