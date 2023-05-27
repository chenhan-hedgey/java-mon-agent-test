package chenhan;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/27 0:00
 */
public class Application {
    public static void main(String[] args) throws Exception {
        ByteBuddyAgent.install();

        Class<? extends Hello> helloClass = new ByteBuddy()
                .subclass(Hello.class)
                .method(ElementMatchers.named("sayHello"))
                .intercept(MethodDelegation.to(Interceptor.class))
                .make()
                .load(Application.class.getClassLoader(), ClassLoadingStrategy.Default.INJECTION)
                .getLoaded();

        Hello hello = helloClass.getDeclaredConstructor().newInstance();
        hello.sayHello();
    }

    public static class Interceptor {
        public static void intercept() {
            System.out.println("Method 'sayHello' was called.");
        }
    }
}

