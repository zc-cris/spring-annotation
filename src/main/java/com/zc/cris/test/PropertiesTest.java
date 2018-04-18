package com.zc.cris.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

import com.zc.cris.bean.Car;
import com.zc.cris.config.MainConfig2;
import com.zc.cris.config.MainConfigOfLifeCycle;
import com.zc.cris.config.MainConfigOfProperties;


public class PropertiesTest {

    AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(MainConfigOfProperties.class);
    public void getBeanNames(AnnotationConfigApplicationContext config) {
        String[] names = config.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    };
    @Test
    public void test01() {
        //可以通过环境变量获取到注入运行环境的配置文件中的值
        ConfigurableEnvironment environment = config.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
        System.out.println(config.getBean("person"));
    }
}
