package com.kyle.annotation;

import com.kyle.enumeration.OperationType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @Author：kyle
 * @gitee: https://gitee.com/kyle20251
 * @Package：com.kyle.annotation
 * @Project：estate-sales-management
 * @Date：2023/12/31 13:14
 * @Filename：AutoFill
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    //拦截操作 UPDATE INSERT
    OperationType value();
}
