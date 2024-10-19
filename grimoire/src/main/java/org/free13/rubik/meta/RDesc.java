package org.free13.rubik.meta;

import java.lang.annotation.*;

/**
 * @author free13
 * Copyright (c) 2024.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.LOCAL_VARIABLE})
@Inherited
public @interface RDesc {
    String value();

    String desc() default "";

    String[] details() default {};
}
