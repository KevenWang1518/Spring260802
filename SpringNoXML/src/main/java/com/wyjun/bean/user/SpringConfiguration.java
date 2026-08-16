package com.wyjun.bean.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration // 将以下类作为配置类，代替配置文件。被这个Configuration注解标注的类也会纳入IoC容器的管理。它本身也是一个Bean。
@ComponentScan(value = {"com.wyjun.bean.user"})//指定要扫描的包，这个包下所有被注解标注的都会实例化。
//@ComponentScan("com.wyjun.bean.user")//如果只扫描一个包，可以简写这种形式。

public class SpringConfiguration {

    //配置一个Bean
    //@Bean// 默认情况下这个bean的名字是方法名。
    @Bean("myNowDate")
    public Date getDate() {
        //自己new的对象就会纳入IoC容器的管理。
        return new Date();
    }
}

