package cn.chenhan.tools.agent.ds;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/25 2:03
 */
public interface ConnectionPool {
    Connection getConnection() throws SQLException;
    void releaseConnection(Connection connection) throws SQLException;
    // 其他连接池操作方法
}