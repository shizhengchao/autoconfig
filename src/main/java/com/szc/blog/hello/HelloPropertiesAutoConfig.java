package com.szc.blog.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * 自动配置HelloService类
 * @EnableConfigurationProperties(HelloProperties.class):开启属性注入，对注解配置Bean的支持
 * @ConditionalOnClass(HelloService.class)：条件注解，当类路径下有指定的类的条件下。
 * @ConditionalOnProperty(prefix = "hello.msg", value = "enabled", matchIfMissing = true)：条件注解，指定的属性是否有指定的值。
 * 当设置hello=enabled,如果没有设置则默认为true，即为条件符合。假如我们将matchIfMissing设置为false，则当设置hello=enabled时，条件为false，
 * 则不会将该Bean加载进容器类，当使用@Autowired注入HelloService时会报错。
 * </pre>
 * @author Administrator
 *
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
@ConditionalOnClass(HelloService.class)
@ConditionalOnProperty(prefix = "hello.msg", value = "enabled", matchIfMissing = true)
public class HelloPropertiesAutoConfig {

	@Autowired
	private HelloProperties properties;

	/**
	 * 当容器中没有指定Bean的情况下，自动配置HelloService类
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(HelloService.class)
	public HelloService helloService() {
		HelloService helloService = new HelloService(properties);
		return helloService;
	}
}
