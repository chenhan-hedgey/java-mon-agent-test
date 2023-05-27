package chenhan.demo2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.matcher.ElementMatchers;

import java.util.concurrent.Callable;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/27 0:07
 */public class Application {
    public static void main(String[] args) throws Exception {
        ByteBuddyAgent.install();

        ByteBuddy byteBuddy = new ByteBuddy();
        new AgentBuilder.Default(byteBuddy)
                .type(ElementMatchers.named("SimpleClass"))
                .transform((builder, typeDescription, classLoader, module) ->
                        builder.method(ElementMatchers.named("getNumber"))
                                .intercept(MethodDelegation.to(Interceptor.class))
                )
                .installOnByteBuddyAgent();

        // 创建一个 SimpleClass 对象并调用 getNumber 方法，这将触发拦截器
        SimpleClass test = new SimpleClass();
        System.out.println("Number: " + test.getNumber());
    }

    public static class Interceptor {
        public static int intercept(@SuperCall Callable<Integer> zuper) throws Exception {
            System.out.println("Method 'getNumber' was called.");
            return zuper.call();
        }
    }
}
