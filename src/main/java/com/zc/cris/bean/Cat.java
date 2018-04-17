package com.zc.cris.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Cat {

    public Cat() {
        System.out.println("cat constructor...");
    }
    @PostConstruct
    public void init() {
        System.out.println("cat @PostConstruct...");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("cat @PreDestroy....");
    }
}
