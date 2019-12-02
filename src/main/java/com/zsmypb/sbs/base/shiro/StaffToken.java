package com.zsmypb.sbs.base.shiro;

import com.zsmypb.sbs.login.domain.LoginParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author zhangs.
 * @date 2019/11/8.
 */
@Data
@AllArgsConstructor
@Slf4j
public class StaffToken extends UsernamePasswordToken {

    private LoginParam loginParam;

//    @Override
//    public void setRememberMe(boolean rememberMe) {
//        super.setRememberMe(loginParam.getRememberMe());
//    }

    @Override
    public Object getPrincipal() {
        return loginParam;
    }

    @Override
    public Object getCredentials() {
        return loginParam.getPassword();
    }
}
