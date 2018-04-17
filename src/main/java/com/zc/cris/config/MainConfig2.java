package com.zc.cris.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;

import com.zc.cris.bean.Book;
import com.zc.cris.bean.Person;
import com.zc.cris.bean.condition.LinuxCondition;
import com.zc.cris.bean.condition.WindowsCondition;
import com.zc.cris.bean.factory.MyFactoryBean;
import com.zc.cris.bean.impo.MyImportBeanDefinitionRegister;
import com.zc.cris.bean.impo.MyImportSelector;

@Conditional({WindowsCondition.class})
@Configuration      
@Import({Book.class,MyImportSelector.class,MyImportBeanDefinitionRegister.class})        //要导入的类和自定义选择器的class 对象
public class MainConfig2 {

  
    @Bean(value = "person")
    public Person person() {
        System.out.println("ioc容器启动的时候");
        return new Person("詹姆斯", 34);
    }
    
    /**
     * @Conditional({Condition}) ： 按照一定的条件进行判断，满足条件给容器中注册bean
     * 
     * 如果系统是windows，给容器中注册("harden")
     * 如果是linux系统，给容器中注册("curry")
     */
    @Conditional({WindowsCondition.class})
    @Bean("harden")
    public Person person01() {
        return new Person("harden", 27);
    }
    
    @Conditional({LinuxCondition.class})
    @Bean("curry")
    public Person person02() {
        return new Person("curry", 29);
    }
    
    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     *      1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     *      2）、ImportSelector:返回需要导入的组件的全类名数组；
     *      3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     *      1）、默认获取到的是工厂bean调用getObject创建的对象
     *      2）、要获取工厂Bean本身，我们需要给id前面加一个&
     *          &colorFactoryBean
     */
    @Bean
    public MyFactoryBean myFactoryBean() {
        return new MyFactoryBean();
    }
    
    
}
