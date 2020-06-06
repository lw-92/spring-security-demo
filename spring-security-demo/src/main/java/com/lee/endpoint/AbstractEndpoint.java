package com.lee.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

public abstract class AbstractEndpoint {
    @RequestMapping("hello")
    public String hello(Principal principal) {
        return this.getClass().getSimpleName() + " hello " + principal.getName();
    }
}
