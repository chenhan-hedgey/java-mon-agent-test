package com.example.monitoring.interceptor;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/27 14:39
 */
public class DemoInterceptor {

    @RuntimeType
    public static Object interceptor(
            @SuperCall Callable<?> callable,
            @Origin Method method,
            @Origin Class<?> clazz,
            @AllArguments Object... args
            ) throws Exception {
        System.out.println("正在拦截hello，本次是：" + Arrays.toString(args));
        return callable.call();
    }

    @Advice.OnMethodExit
    public static void onConstructor(
            @Advice.Origin Constructor<?> constructor,
            @Advice.This Object instance
            ){
        System.out.println("本次拦截的是" + constructor.toString() + "参数：" );

    }
}
