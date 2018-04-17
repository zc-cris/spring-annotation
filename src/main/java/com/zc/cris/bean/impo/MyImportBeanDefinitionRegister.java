package com.zc.cris.bean.impo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.zc.cris.bean.Customer;

public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar{

    /*
     * beanDefinitionRegistry:BeanDifinition 注册类：将需要注入到容器中的bean 手工注册进来
     * AnnotationMetadata：当前类的注解信息
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean flag1 = beanDefinitionRegistry.containsBeanDefinition("com.zc.cris.bean.Book");
        boolean flag2 = beanDefinitionRegistry.containsBeanDefinition("com.zc.cris.bean.Shop");
        if(flag1 && flag2) {
            // 指定bean 的定义信息
            BeanDefinition beanDefinition = new RootBeanDefinition(Customer.class);
            // 注册一个bean，指定bean的名字
            beanDefinitionRegistry.registerBeanDefinition("customer", beanDefinition);
        }
    }

}
