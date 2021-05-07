package com.sun.annotation;

import java.lang.annotation.*;

/**
 * create by qiulisun on 2020/12/7.<br>
 * @author 51050
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitAnnotation {
    /** 供应商编号 */
    public int id() default -1;

    /** 供应商名称 */
    public String name() default "";

    /** 供应商地址 */
    public String address() default "";
}
