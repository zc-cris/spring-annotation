package com.zc.cris.orm;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.zc.cris.bean.Person;
import com.zc.cris.bean.factory.MyFactoryBean;
import com.zc.cris.config.MainConfig;
import com.zc.cris.config.MainConfig2;

public class TestAnnotation {

    AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(MainConfig2.class);
    public void getBeanNames(AnnotationConfigApplicationContext config) {
        String[] names = config.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    };
    
    /*
     * 测试@import 注解
     */
    @Test
    public void testImport() {
        getBeanNames(config);
        
        // 工厂bean 获取的是调用getObject 方法返回的对象
        Object bean = config.getBean("myFactoryBean");
        Object bean1 = config.getBean("myFactoryBean");
        System.out.println(bean.getClass());    //class com.zc.cris.bean.Boss
        System.out.println(bean == bean1);
        Object bean2 = config.getBean("&myFactoryBean");
        System.out.println(bean2.getClass()); // class com.zc.cris.bean.factory.MyFactoryBean
    }
   
    
    @Test
    public void test03() {
        
        ConfigurableEnvironment environment = config.getEnvironment();
        // 动态获取环境变量的值
        String os = environment.getProperty("os.name");
        System.out.println(os);
        
        // 根据类型获取ioc容器中所有实例对象的id
        String[] names = config.getBeanNamesForType(Person.class);
        for (String string : names) {
            System.out.println(string);
        }
        
        // 根据类型获取ioc容器中所有的实例对象，以map 呈现
        Map<String, Person> map = config.getBeansOfType(Person.class);
        System.out.println(map);
    }
    
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
        
        System.out.println("ioc容器启动完成");
        Person p1 = config.getBean(Person.class);
        Person p2 = config.getBean(Person.class);
        System.out.println(p1 == p2);
        
    }
}
