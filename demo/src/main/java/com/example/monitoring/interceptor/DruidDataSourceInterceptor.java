package com.example.monitoring.interceptor;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @Author: chenhan
 * @Description: 测试
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/27 13:00
 */
public class DruidDataSourceInterceptor {

    @RuntimeType
    public static Object interceptor(
            @Origin Class<?> clazz,
            @Origin Method method,
            @SuperCall Callable<?> callable,
            @AllArguments Object[] args
            ) throws Exception {
        System.out.println("调用druid开始");
        System.out.println(Arrays.toString(args));
        System.out.println(method);
        System.out.println(clazz);
        Object call = callable.call();
        System.out.println(call);
        return call;
    }
}
