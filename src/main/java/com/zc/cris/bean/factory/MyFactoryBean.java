package com.zc.cris.bean.factory;

import org.springframework.beans.factory.FactoryBean;

import com.zc.cris.bean.Boss;

// 创建一个自定义的factoryBean
public class MyFactoryBean implements FactoryBean<Boss>{

    
    //返回一个 Boss 对象，并添加到ioc 容器中
    @Override
    public Boss getObject() throws Exception {
        
        return new Boss();
    }

    // 返回Boss 对象的类型
    @Override
    public Class<?> getObjectType() {
        
        return Boss.class;
    }
    
    // 是否单例？true：单例，容器中保存一份；false：多实例，每次获取都会创建一份
    @Override
    public boolean isSingleton() {
        
        return true;
    }

}
