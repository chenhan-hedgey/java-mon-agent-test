package com.example.monitoring;

import com.example.monitoring.interceptor.*;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;
import java.sql.Connection;

import static net.bytebuddy.matcher.ElementMatchers.*;

public class Application {

    public static void premain(String args, Instrumentation instrumentation) throws Exception {


        new AgentBuilder.Default()
                .with(new AgentBuilder.Listener.WithErrorsOnly(AgentBuilder.Listener.StreamWriting.toSystemError()))
                .type(named("com.example.monitoring.model.Demo"))
                .transform((builder, typeDescription, classLoader, javaModule) -> {
                    return builder.method(ElementMatchers.named("hello"))
                            .intercept(MethodDelegation.to(DemoInterceptor.class));
                })
                .transform((builder, typeDescription, classLoader, javaModule) -> {
                    return builder.visit(Advice.to(DemoInterceptor.class).on(isConstructor()));
                })
                .installOn(instrumentation);



        ElementMatcher.Junction<NamedElement> startMatcher = null;
        startMatcher = ElementMatchers.nameStartsWith("com.alibaba.druid.pool");

        new AgentBuilder.Default()
                .with(new AgentBuilder.Listener.WithErrorsOnly(AgentBuilder.Listener.StreamWriting.toSystemError()))
                .type(ElementMatchers.nameStartsWith("com.alibaba.druid.")
                        .and(ElementMatchers.hasSuperType(ElementMatchers.named("java.sql.Connection"))))
                .transform((builder, typeDescription, classLoader, javaModule) -> builder
                        .method(ElementMatchers.named("createStatement")
                                .or(ElementMatchers.named("prepareStatement"))
                                .or(ElementMatchers.named("close")))
                        .intercept(MethodDelegation.to(ConnectionInterceptor.class))
                )
//                .transform((builder, typeDescription, classLoader, javaModule) -> builder
//                        .constructor(ElementMatchers.any())
//                        .intercept(MethodDelegation.to(ConnectionInterceptor.class,"onConstructor")))
                .installOn(instrumentation);

//        new AgentBuilder.Default()
//                .type(startMatcher.and(ElementMatchers.isSubTypeOf(Connection.class)))
//                .transform((builder, typeDescription, classLoader, module) ->
//                        builder.method(ElementMatchers.isPublic().and(not(isAbstract())).and(not(isDefaultMethod())))
//                                .intercept(MethodDelegation.to(DruidDataSourceInterceptor.class))
//                )
//                .installOn(instrumentation);
        int i = 0;
        System.out.println("main");
    }
}
