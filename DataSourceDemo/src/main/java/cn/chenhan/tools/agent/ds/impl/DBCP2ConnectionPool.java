package cn.chenhan.tools.agent.ds.impl;

import cn.chenhan.tools.agent.ds.AbstractConnectionPool;
import cn.chenhan.tools.agent.ds.model.DataSourceInfo;
import cn.chenhan.tools.agent.ds.model.DatabaseInfo;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/25 2:25
 */
public class DBCP2ConnectionPool extends AbstractConnectionPool {
    public DBCP2ConnectionPool(DatabaseInfo databaseInfo, DataSourceInfo dataSourceInfo) {
        super(databaseInfo, dataSourceInfo);
    }

    @Override
    protected DataSource initDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(super.databaseInfo.getUrl());
        basicDataSource.setUsername(super.databaseInfo.getUsername());
        basicDataSource.setPassword(super.databaseInfo.getPassword());
        basicDataSource.setMaxTotal(super.dataSourceInfo.getMaxConnections());
        basicDataSource.setMinIdle(super.dataSourceInfo.getMinIdleConnections());
        basicDataSource.setInitialSize(super.dataSourceInfo.getInitialConnections());
        return basicDataSource;
    }
}
