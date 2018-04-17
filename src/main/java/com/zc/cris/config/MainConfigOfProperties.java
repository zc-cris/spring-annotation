package com.zc.cris.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zc.cris.bean.Person;

@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfProperties {

   @Bean
  public Person person() {
      return new Person();
  }
}
