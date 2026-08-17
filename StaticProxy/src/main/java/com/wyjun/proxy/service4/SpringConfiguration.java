package com.wyjun.proxy.service4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 将以下类作为配置类，代替配置文件。被这个Configuration注解标注的类也会纳入IoC容器的管理。它本身也是一个Bean。
@ComponentScan(value = {"com.wyjun.proxy.service4"})//指定要扫描的包，这个包下所有被注解标注的都会实例化。
//@ComponentScan("com.wyjun.proxy.service4")//如果只扫描一个包，可以简写这种形式。

public class SpringConfiguration {

}

