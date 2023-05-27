import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.util.FileSize;
import org.slf4j.LoggerFactory;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/26 17:33
 */

public class LoggingConfigurator {

    // 创建一个公共静态方法用来配置全局日志
    public static void configureGlobalLogging(String logFilePath) {

        // 获取当前的Logger上下文
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        // 清除当前Logger上下文的所有配置
        loggerContext.reset();

        // 创建并配置一个PatternLayoutEncoder，用来设置日志的输出格式
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(loggerContext);
        encoder.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
        encoder.start(); // 启动encoder

        // 创建并配置一个滚动文件Appender，用来设置日志的输出文件
        RollingFileAppender rollingFileAppender = new RollingFileAppender();
        rollingFileAppender.setContext(loggerContext);
        rollingFileAppender.setName("fileAppender");
        rollingFileAppender.setEncoder(encoder);
        rollingFileAppender.setAppend(true);
        rollingFileAppender.setFile(logFilePath);  // 设置日志的输出文件路径

        // 创建并配置一个基于时间的滚动策略，用来设置日志文件的滚动方式
        TimeBasedRollingPolicy rollingPolicy = new TimeBasedRollingPolicy();
        rollingPolicy.setContext(loggerContext);
        rollingPolicy.setParent(rollingFileAppender);
        rollingPolicy.setFileNamePattern(logFilePath + ".%d{yyyy-MM-dd}.log"); // 设置滚动日志文件的命名模式
        rollingPolicy.setMaxHistory(30);  // 设置滚动日志文件的最大历史记录数
        rollingPolicy.setTotalSizeCap(FileSize.valueOf("32GB"));  // 设置滚动日志文件的最大总容量
        rollingPolicy.start();  // 启动滚动策略

        // 将滚动策略应用到滚动文件Appender
        rollingFileAppender.setRollingPolicy(rollingPolicy);
        rollingFileAppender.start(); // 启动滚动文件Appender

        // 获取root logger，并设置其级别和Appender
        ch.qos.logback.classic.Logger rootLogger = loggerContext.getLogger("ROOT");
        rootLogger.setLevel(Level.DEBUG);  // 设置root logger的级别
        rootLogger.addAppender(rollingFileAppender);  // 给root logger添加滚动文件Appender
    }
}