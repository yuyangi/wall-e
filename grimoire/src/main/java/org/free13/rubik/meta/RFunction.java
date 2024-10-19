package org.free13.rubik.meta;

import java.lang.annotation.*;

/**
 * @author free13
 * Copyright (c) 2024.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RFunction {

    String name() default ""; // 字段名称

    String[] alias() default {};

    String code() default "";

}
