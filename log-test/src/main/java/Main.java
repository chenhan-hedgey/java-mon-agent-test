import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/26 17:36
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir")+"\\" + "chenhan\\file.log";
        System.out.println(dir);
//        String logFilePath = "/chenhan/log/test.log";
//
//        // 检查目录是否存在，如果不存在，就创建目录
//        Path logPath = Paths.get(logFilePath).getParent();
//        System.out.println("创建目录");
//        System.out.println(Files.exists(logPath));
//        if (!Files.exists(logPath)) {
//            try {
//                System.out.println("创建目录2");
//                Files.createDirectories(logPath);
//                System.out.println("创建目3");
//            } catch (IOException e) {
//                System.out.println("失败");
//                e.printStackTrace();
//            }
//        }
//        System.out.println(logPath.toAbsolutePath().toString());
//        LoggingConfigurator.configureGlobalLogging(logFilePath);
//        logger.info("info");
//        logger.debug("debug");
//        logger.warn("info");
//        logger.error("info");
    }
}
