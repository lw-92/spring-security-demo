package com.lee.login;

import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * 自定义一个短信的authentication
 */
public class SmsAuthenticationToken extends AbstractAuthenticationToken {

    private String smsCode;
    private String mobile;

    public SmsAuthenticationToken(String smsCode, String mobile) {
        super(null);
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
