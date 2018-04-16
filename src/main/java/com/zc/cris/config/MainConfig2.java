package com.zc.cris.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;

import com.zc.cris.bean.Person;

@Configuration      
@ComponentScans(value = {
        @ComponentScan(value = "com.zc.cris.orm", excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class, Repository.class})
        })
})

public class MainConfig2 {

    /*
     * @Scope:调整作用域
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     *                  每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     *          以后每次获取就是直接从容器（map.get()）中拿，
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     */
    @Scope(value = "prototype")
    @Bean(value = "myPerson")
    public Person person() {
        System.out.println("ioc容器启动的时候");
        return new Person("詹姆斯", 34);
    }
}
