package cn.chenhan.tools.agent.ds;


import cn.chenhan.tools.agent.ds.model.DataSourceInfo;
import cn.chenhan.tools.agent.ds.model.DatabaseInfo;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/25 2:14
 */
public abstract class AbstractConnectionPool implements ConnectionPool {
    private DataSource dataSource;

    protected DatabaseInfo databaseInfo;
    protected DataSourceInfo dataSourceInfo;

    public AbstractConnectionPool(DatabaseInfo databaseInfo, DataSourceInfo dataSourceInfo) {
        this.databaseInfo = databaseInfo;
        this.dataSourceInfo = dataSourceInfo;
        this.dataSource = initDataSource();
    }


    protected abstract DataSource initDataSource();



    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void releaseConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
