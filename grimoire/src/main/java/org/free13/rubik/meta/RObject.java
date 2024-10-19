package org.free13.rubik.meta;

import java.lang.annotation.*;

/**
 * @author free13
 * Copyright (c) 2024.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
@Inherited
public @interface RObject {

    String name(); // 表名称（中文）
    String[] alias() default {}; // 别名
    String code(); // 编码
    String comment() default ""; // 表注释

}
