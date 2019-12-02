package com.zsmypb.spb.hello.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hello {

    private String id;
    private String hello;
    private String world;
}
