package cn.chenhan.tools.agent;

import cn.chenhan.tools.agent.ds.ConnectionPool;
import cn.chenhan.tools.agent.ds.impl.DBCP1ConnectionPool;
import cn.chenhan.tools.agent.ds.model.DataSourceInfo;
import cn.chenhan.tools.agent.ds.model.DatabaseInfo;
import cn.chenhan.tools.agent.mock.SQLAlias;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/25 2:26
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        DatabaseInfo databaseInfo = DatabaseInfo.builder()
                .url("jdbc:h2:mem:test;MODE=MYSQL")
                .username("sa")
                .password("").build();
        DataSourceInfo dataSourceInfo = DataSourceInfo.builder().maxConnections(10).minIdleConnections(3).initialConnections(5).build();

        ConnectionPool pool = new DBCP1ConnectionPool(databaseInfo, dataSourceInfo);

        {
            try(Connection connection = pool.getConnection()){
                Statement statement = connection.createStatement();
                statement.execute(SQLAlias.aliasSQL);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 20; i++) {
            try(Connection connection = pool.getConnection()){
                Statement statement = connection.createStatement();
                int num = new Random().nextInt(10000);
                statement.execute("select delay("+num+") from dual");
                logger.info("第{}次：select delay({}) from dual",i,num);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
