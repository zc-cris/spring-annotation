package com.zc.cris.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.zc.cris.bean.Calculator;
import com.zc.cris.bean.Car;
import com.zc.cris.bean.Person;
import com.zc.cris.config.MainConfigOfAOP;
import com.zc.cris.config.MainConfigOfLifeCycle;
import com.zc.cris.config.MainConfigOfProfile;


public class AOPTest {

    AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
      

    @Test
    public void test() {
        Calculator bean = config.getBean(Calculator.class);
        Integer num = bean.div(12, 2);
        System.out.println("运行结果是："+num);
    }
}
