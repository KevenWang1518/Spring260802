package com.wyjun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

// 用它标注表示一个配置类。代替spring.xml配置文件的。本身也会纳入IoC容器的管理，它本身也是一个Bean
@Configuration

//组件扫描   代替<context:component-scan base-package="com.wyjun"/>
@ComponentScan("com.wyjun")

//启用自动代理，并且使用CGLIB的动态代理技术。   代替<aop:aspectj-autoproxy proxy-target-class="true"/>
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class SpringConfig {
}
