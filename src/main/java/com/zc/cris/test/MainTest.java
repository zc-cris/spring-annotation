package com.zc.cris.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zc.cris.bean.Person;
import com.zc.cris.config.MainConfig;

public class MainTest {
    
    public static void main(String[] args) {
        
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);
        
        String[] names = context.getBeanNamesForType(Person.class);
        for (String string : names) {
            System.out.println(string);     // 打印的就是我们@Bean 注解的value值
        }
        
    }
}
