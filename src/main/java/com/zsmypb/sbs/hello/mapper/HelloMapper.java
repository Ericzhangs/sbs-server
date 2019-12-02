package com.zsmypb.sbs.hello.mapper;

import com.zsmypb.sbs.hello.domain.Hello;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HelloMapper {
    List<Hello> getHelloList();
}
