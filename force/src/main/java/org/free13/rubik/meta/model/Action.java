package org.free13.rubik.meta.model;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Action {

    @AliasFor("name")
    String value() default "";

    String name() default "";

    String code() default "";

    String[] alias() default {};

    String desc() default "";

}
