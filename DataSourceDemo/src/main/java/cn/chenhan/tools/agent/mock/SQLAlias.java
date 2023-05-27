package cn.chenhan.tools.agent.mock;

import lombok.Data;

/**
 * @Author: chenhan
 * @Description: 模拟连接
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/25 1:16
 */

public class SQLAlias {
    public  static final String aliasSQL = "CREATE ALIAS DELAY FOR \"cn.chenhan.tools.agent.mock.SQLAlias.delay\"";
    public static void delay(Integer milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }


}
