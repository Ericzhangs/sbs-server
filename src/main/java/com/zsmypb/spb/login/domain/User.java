package com.zsmypb.spb.login.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {

    private String userId;
    private String username;
    private String password;
//    private List<Role> roles;
}
