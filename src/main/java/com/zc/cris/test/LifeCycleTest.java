package com.zc.cris.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.zc.cris.bean.Car;
import com.zc.cris.config.MainConfigOfLifeCycle;


public class LifeCycleTest {

    AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    public void test02() {
        config.close();
    }
    
    @Test
    public void test01() {
        System.out.println("ioc容器创建完成");
        Car car = config.getBean(Car.class);
        config.close();
        
    }
}
