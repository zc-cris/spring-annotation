package com.zc.cris.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.zc.cris.bean.Car;
import com.zc.cris.bean.Person;
import com.zc.cris.config.MainConfigOfLifeCycle;
import com.zc.cris.config.MainConfigOfProfile;


public class ProfileTest {

//    AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
      AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
      

    //1. 使用命令行参数（虚拟机参数设置：-Dspring.profiles.active=test）
    //2. 使用代码的方式激活指定环境:
    /*
     * - 无参构造 AnnotationConfigApplicationContext，然后自己设置指定环境参数，再注册配置类，最后refresh 即可
     */
    @Test
    public void test() {
        config.getEnvironment().setActiveProfiles("dev");
        config.register(MainConfigOfProfile.class);
        config.refresh();
        String[] names = config.getBeanNamesForType(DataSource.class);
        for (String string : names) {
            System.out.println(string);
        }
        Person bean = config.getBean(Person.class);
        System.out.println(bean);
    }
}
