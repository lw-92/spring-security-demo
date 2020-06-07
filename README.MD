spring security的使用以及相关流程分析

#springboot集成简单配置

##基础权限配置
已完成

#session中的context设置
SecurityContextPersistenceFilter 在整个security的过滤链的第一个，会将authentication的信息存入到session中，request
时读取，response时放入，这样就保证了登录后不用在重复登录；
##匿名用户
已完成

##自定义登录成功处理逻辑
Done

##自定义没有权限处理逻辑
Done

##退出登录的配置~~~~

logout 中使用，定义logout的成功处理方式即可

##自定义多种登录方式

done

##内置过滤器作用详解
[参考](https://www.felord.cn/spring-security-filters.html)


##使用Expression-Based Access Control

使用hasRole时需要加前缀ROLE_

##remember me功能

存储了一个token,然后设置了cookie，下次登录时，只需要校验cookie即可登录


#spring  security oauth2的demo

##oauth2授权/资源服务搭建

##执行流程分析

##自定义登录和授权界面

##多实例的授权服务部署改造

##集成spring cloud gateway


#spring  social 的demo


#spring webflux的支持

##使用微信登录demo

##使用微信登录执行流程和原理
