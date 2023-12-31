package com.kyle.aspect;

import com.kyle.annotation.AutoFill;
import com.kyle.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @description:
 * @Author：kyle
 * @gitee: https://gitee.com/kyle20251
 * @Package：com.kyle.aspect
 * @Project：estate-sales-management
 * @Date：2023/12/31 13:14
 * @Filename：AutoFillAspect
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {


    //插入点
    @Pointcut("execution(* com.kyle.mapper.*.*(..)) && @annotation(com.kyle.annotation.AutoFill)")
    public void autoFillPointCut() {
    }

    //通知 进行公共字段赋值
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) {
        //获取当前方法的数据库操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType operationType = autoFill.value();//获取当前注解的操作类型

        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0 || ObjectUtils.isEmpty(args)) {
            return;
        }
        //获取当前被拦截的方法参宿
        Object entity = args[0];

        LocalDateTime now = LocalDateTime.now();
        if (operationType == OperationType.INSERT) {
            try {
                Method setCreateTime = entity.getClass().getDeclaredMethod("setCreateTime", LocalDateTime.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);

                setUpdateTime.invoke(entity, now);
                setCreateTime.invoke(entity, now);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (operationType == OperationType.UPDATE) {
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class);
                setUpdateTime.invoke(entity, now);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
