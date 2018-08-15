package com.gameloft9.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义校验注解
 * Created by gameloft9 on 2018/8/14.
 */
@Target({FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {CommonCharactorValidator.class}) //具体的实现
public @interface CommonCharactor {
    String message() default "包含非法字符";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    CharactorRule charactorRule() default  CharactorRule.Normal;
}
