package org.ycframework.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //TYPE
@Retention(RetentionPolicy.RUNTIME)
public @interface YcComponent {
    String value() default "";
}
