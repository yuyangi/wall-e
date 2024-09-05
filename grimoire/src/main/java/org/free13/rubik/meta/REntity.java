package org.free13.rubik.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 *
 * @author free13
 * Copyright (c) 2024.
 */

/**
 * @author free13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
public @interface REntity {

    String name(); // 表名称（中文）
    String[] alias() default {}; // 别名
    String code(); // 编码
    String comment() default ""; // 表注释
    String dbType() default "mysql"; // 数据库类型
    String dbName() default "default";
    String schema() default "public"; // 模式
    String tableName() default "";

}
