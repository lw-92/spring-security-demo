package com.lee.endpoint;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注解方式来做权限控制，具体的expression表达式可以参考,
 * 平时开发中应该更多使用此中方式
 * <p>
 * https://docs.spring.io/spring-security/site/docs/5.2.4.RELEASE/reference/htmlsingle/#el-access
 */
@RestController
@RequestMapping("annotation")
public class AnnotationEndpoint {

    /**
     * todo  hasRole
     *
     * @return
     */
    @RequestMapping("hello1")
    @PreAuthorize("hasAnyRole('user','admin')")
    public String hello1() {
        return "hello1";
    }

    @RequestMapping("hello2")
    @PreAuthorize("hasRole('user')")
    public String hello2() {
        return "hello2";
    }

    /**
     * 基于权限的控制
     *
     * @return
     */
    @RequestMapping("hello3")
    @PreAuthorize("hasAnyAuthority('delete')")
    public String hello3() {
        return "hello3";
    }

    @RequestMapping("hello4")
    @PreAuthorize("hasAnyAuthority('delete','read')")
    public String hello4() {
        return "hello4";
    }
}
