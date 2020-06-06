package com.lee.endpoint;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;

public abstract class AbstractEndpoint {
    @RequestMapping("hello")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return this.getClass().getSimpleName() + " hello " + authentication.getPrincipal();
    }
}
