package com.zc.cris.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zc.cris.bean.Person;


/**
 * Profile：
 *      Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 * 
 * 开发环境、测试环境、生产环境；
 * 数据源：(/A)(/B)(/C)；
 * 
 * 
 * @Profile：指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 * 
 * 1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的bean在，任何环境下都是加载的；
 */
//@Profile("test")
@PropertySource({"classpath:db.properties","classpath:/person.properties"})
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    // 三种方式读取配置文件中的值
    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;
    private String driverClass;

//    @Profile("test")
    @Bean
    public Person person() {
        return new Person("cris", 23);
    }
    
    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(this.driverClass);
        dataSource.setJdbcUrl("jdbc:mysql:///ssm_crud");
        return dataSource;
    }

    @Profile("dev")
    @Bean("DevDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(this.driverClass);
        dataSource.setJdbcUrl("jdbc:mysql:///mysql");
        return dataSource;
    }

    @Profile("prod")
    @Bean("ProdDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(this.driverClass);
        dataSource.setJdbcUrl("jdbc:mysql:///common_mapper");
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        this.driverClass = this.resolver.resolveStringValue("${db.db.driverClass}");
    }

}
