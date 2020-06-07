package com.lee.login;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 自定义一个短信的authentication
 */
public class SmsAuthenticationToken extends AbstractAuthenticationToken {

    private String smsCode;
    private String mobile;

    public SmsAuthenticationToken(String smsCode, String mobile,Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.smsCode = smsCode;
        this.mobile = mobile;
    }

    @Override
    public Object getCredentials() {
        return smsCode;
    }

    @Override
    public Object getPrincipal() {
        return mobile;
    }


}
