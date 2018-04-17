package com.zc.cris.bean.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

// 判断Linux 操作环境
public class LinuxCondition implements Condition{

    /*
     * conditionContext:判断条件能使用的上下文环境
     * annotatedTypeMetadata：注释信息
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //1. 获取ioc容器使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        
        //2. 获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        
        //3. 获取bean的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        boolean flag = registry.containsBeanDefinition("person");   // 判断注册类中是否有某个bean
        
        //4. 获取当前系统环境
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");
        if(property.contains("linux")) {
            return true;
        }
        return false;
    }

}
