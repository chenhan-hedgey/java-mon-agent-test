package com.example.monitoring;

/**
 * @Author: chenhan
 * @Description: ${DESCRIPTION}
 * @ProjectName: Default (Template) Project
 * @Date: 2023/5/31 13:06
 */
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class ConstructorInterceptorAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        new AgentBuilder.Default()
                .type(ElementMatchers.any()) // 拦截所有类
                .transform((builder, type, classLoader, module) -> builder
                        .constructor(ElementMatchers.isConstructor()) // 拦截构造函数
                        .intercept(Advice.to(Interceptor.class))) // 应用拦截器
                .installOn(instrumentation);
    }

    public static class Interceptor {
        @Advice.OnMethodEnter
        public static void enter(@Advice.AllArguments Object[] args) {
            // 在构造函数执行之前拦截，并可以修改参数
            System.out.println("Intercepted constructor");
            args[0] = "Intercepted: " + args[0];
        }
    }
}
