package com.lee.login;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SmsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public SmsAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        // 拦截login的post请求
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {


        if (request.getContentType() == null || !request.getContentType().contains("json")) {
            throw new AuthenticationServiceException("请求头类型不支持: " + request.getContentType());
        }
        SmsAuthenticationToken authRequest;
        try {
            String mobile = request.getParameter("mobile");
            String smsCode = request.getParameter("smsCode");
            authRequest = new SmsAuthenticationToken(smsCode,mobile);
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
        return this.getAuthenticationManager().authenticate(authRequest);
    }

}
