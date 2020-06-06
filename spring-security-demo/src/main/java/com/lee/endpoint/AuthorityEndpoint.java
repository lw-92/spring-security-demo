package com.lee.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("authority")
public class AuthorityEndpoint {

    @RequestMapping("delete")
    public String delete(Principal principal) {
        return "delete" + principal.getName();
    }

    @RequestMapping("add")
    public String add(Principal principal) {
        return "add" + principal.getName();
    }
}
