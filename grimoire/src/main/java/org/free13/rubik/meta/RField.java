package org.free13.rubik.meta;

import java.lang.annotation.*;

/**
 * @author free13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Inherited
public @interface RField {

    String name() default ""; // 字段名称

    String[] alias() default {};

    String type(); // 数据类型

    boolean primaryKey() default false; // 是否为主键

    boolean nullable() default true; // 是否不允许为空

    String defaultValue() default ""; // 默认值

    boolean unique() default false; // 是否唯一

    String desc() default ""; // 字段注释

    boolean autoIncrement() default false;

}
