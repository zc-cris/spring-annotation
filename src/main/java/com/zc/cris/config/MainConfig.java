package com.zc.cris.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;

import com.zc.cris.bean.Person;

//配置类 == 配置文件
@Configuration      // 这个注解的作用就是告诉Spring这是一个配置类
@ComponentScans(value = {
        @ComponentScan(value = "com.zc.cris.orm", includeFilters = {
                @Filter(type = FilterType.CUSTOM, classes = {MyFilter.class}
                )
            
}, useDefaultFilters = false)
})
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式(不常用)
//FilterType.REGEX：使用正则指定（不常用）
//FilterType.CUSTOM：使用自定义规则（重点）
public class MainConfig {

    // 给容器中注册一个Bean，类型就是返回值的类型，id默认就是方法名（通常使用@Bean注解的value熟悉来自定义id值）
    @Bean(value = "myPerson")
    public Person person() {
        return new Person("cris", 12);
    }
}
