package com.sun.annotation;

import java.lang.annotation.*;

/**
 * create by qiulisun on 2020/11/17.<br>
 *
 * @author 51050
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
public @interface UserAnnotation {
}
