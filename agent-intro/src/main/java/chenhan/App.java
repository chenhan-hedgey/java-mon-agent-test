package chenhan;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/26 21:05
 */
public class App {
    public static void main(String args){
        // 方法的转换器，将JDBCAPIInterceptor类应用于所有公共非抽象方法上
        ByteBuddy byteBuddy = new ByteBuddy();
        new AgentBuilder.Default(byteBuddy)
                .type(ElementMatchers.named("chenhan.Demo"))
                .transform(((builder, typeDescription, classLoader, javaModule) -> {
                    return builder.method(ElementMatchers.named("hello"))
                            .intercept(MethodDelegation.to(DemoInterceptor.class));
                })).installOnByteBuddyAgent();
    }
}
