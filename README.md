---
layout: pattern
title: autoconfig
tags:
 - Java
 - autoconfig
 - springboot
---

自定义实现springboot starter

1.实现HelloProperties类属性配置

2.定义一个需要自动配置的类: HelloService

3.定义自动配置类:HelloPropertiesAutoConfig

4.在resources/META-INF/新建spring.factories(非必须，如果不加spring.factories,则需要在启动类中加入@ImportAutoConfiguration({HelloPropertiesAutoConfig.class}) )文件,写入如下内容:
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.szc.blog.hello.HelloPropertiesAutoConfig

5.pom中引入自己的starter，查看效果