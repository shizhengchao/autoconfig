package com.szc.blog.hello;

public class HelloService {
	
	private HelloProperties properties;

	public HelloService() {
		
	}
	
	public String sayHello() {
		return "Hello, " + properties.getName();
	}
	
	public HelloService(HelloProperties properties) {
		this.properties = properties;
	}
}
