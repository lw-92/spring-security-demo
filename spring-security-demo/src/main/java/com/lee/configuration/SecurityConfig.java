package com.lee.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()// 授权配置
                .antMatchers("/noauth/**").permitAll() //注意要以'/' 开头
                .antMatchers("/admin/**").hasRole("admin") //admin必须要有admin角色才能访问
                .antMatchers("/user/**").hasAnyRole("admin", "user")  //admin  或者user能访问
                .antMatchers("/authority/delete").hasAuthority("delete") //必须要有delete权限
                .antMatchers("/authority/add").hasAuthority("add") //必须要有add权限
                .anyRequest().authenticated()
                .and()
                .formLogin() // 登录配置，这里会加入一个UsernamePasswordAuthenticationFilter
                .and()
                .httpBasic();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // ensure the passwords are encoded properly
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //配置了权限
        manager.createUser(users.username("user").password("password").roles("user").authorities("delete", "add").build());
        manager.createUser(users.username("admin").password("password").roles("user", "admin").build());
        return manager;
    }

    /**
     * 定义AuthenticationManager
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
