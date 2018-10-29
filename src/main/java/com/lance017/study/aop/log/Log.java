package com.lance017.study.aop.log;

import java.lang.annotation.*;

/**
 * @author lance
 * @date Created by on 2018/10/29.下午8:42
 */


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String value() default "操作日志";

}
