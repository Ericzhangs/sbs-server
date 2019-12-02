package com.zsmypb.sbs.login.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String userId;
    private String username;
    private String password;
//    private List<Role> roles;
}
