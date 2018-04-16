package com.zc.cris.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyFilter implements TypeFilter {

    /*
     *  metadataReader:读取到当前正在扫描的类的信息
     *  metadataReaderFactory：可以获取到其他任何类的信息
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        // 获取当前被扫描类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前被扫描类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前被扫描类的资源的信息（类路径...）
        Resource resource = metadataReader.getResource();
        
        String className = classMetadata.getClassName();
        System.out.println("---------"+className);
        // 自定义扫描规则
        if(className.contains("er")) {
            return true;
        }
        return false;
    }

}
