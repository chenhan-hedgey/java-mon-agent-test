package chenhan;

import net.bytebuddy.implementation.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/26 21:07
 */
public class DemoInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(DemoInterceptor.class);
    @RuntimeType
    public static Object intercept(@Origin Class<?> clazz, @Origin Method method, @SuperCall Callable<?> callable, @This Object inst,
                                            @AllArguments Object[] args) throws Exception {
        logger.info("进入成功");
        System.out.println("进入成功");
        return callable.call();
    }
}
