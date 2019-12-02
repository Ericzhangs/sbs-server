package com.zsmypb.spb.login.domain;

import lombok.Data;

@Data
public class LoginParam {

    private String userName;
    private String password;
    private Boolean rememberMe;
}
