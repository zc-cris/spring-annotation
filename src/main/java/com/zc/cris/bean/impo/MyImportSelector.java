package com.zc.cris.bean.impo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// 自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector{

    // 返回值就是要导入到容器中的组件全类名
    // annotationMetadata:当前标注@Import 注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 不要返回null，否则空指针异常
        return new String[] {"com.zc.cris.bean.Shop"};
    }

}
