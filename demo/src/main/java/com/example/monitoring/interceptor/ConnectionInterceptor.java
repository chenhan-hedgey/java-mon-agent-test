package com.example.monitoring.interceptor;

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
 * @Date: 2023/5/27 13:48
 */
public class ConnectionInterceptor {
    @RuntimeType
    public static Object intercept(
            @Origin Class<?> clazz,
            @Origin Method method,
            @SuperCall Callable<?> callable,
            @AllArguments Object[] args
    ) throws Exception {
        System.out.println("调用druid开始");
        System.out.println(Arrays.toString(args));
        System.out.println(method);
        return callable.call();
    }

//
//    public static void onConstructor(
//            @Origin Class<?> clazz,
//            @SuperCall Callable<?> callable,
//            @AllArguments Object[] args) throws Exception {
//        // 您的拦截逻辑
//        System.out.println("Constructor called for ");
//        callable.call();
//    }
//
//    public static void onConstructor(
//            @Origin Class<?> clazz,
//            @Origin Constructor<?> constructor,
//            @SuperCall Callable<?> callable,
//            @AllArguments Object[] args
//    ) {
//        System.out.println("Constructor called for " + constructor.getDeclaringClass());
//        try {
//            callable.call();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
