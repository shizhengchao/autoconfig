package com.szc.blog.hello;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置,配置前缀为 hello.msg 的属性
 * 
 * @author Administrator
 *
 */
@ConfigurationProperties(prefix = "hello.msg")
public class HelloProperties {

	private static String NAME = "World";

	private String name = NAME;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
