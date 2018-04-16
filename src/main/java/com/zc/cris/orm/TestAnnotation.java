package com.zc.cris.orm;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zc.cris.bean.Person;
import com.zc.cris.config.MainConfig;
import com.zc.cris.config.MainConfig2;

public class TestAnnotation {

    @Test
    public void test01 () {
        
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = config.getBeanDefinitionNames();
        for (String string : names) {
            System.out.println(string);
        }
    }
    
    @Test
    public void test02 () {
        
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("ioc容器启动完成");
        Person p1 = config.getBean(Person.class);
        Person p2 = config.getBean(Person.class);
        System.out.println(p1 == p2);
        
    }
}
