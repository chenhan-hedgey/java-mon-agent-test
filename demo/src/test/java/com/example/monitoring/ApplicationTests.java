package com.example.monitoring;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.example.monitoring.model.Demo;
import net.bytebuddy.agent.ByteBuddyAgent;
import org.junit.jupiter.api.Test;


import javax.sql.DataSource;
import java.lang.instrument.Instrumentation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ApplicationTests {

    public static void main(String[] args) throws Exception{

        new Demo().hello("chenhan");
        new Demo("chenhan").hello();
        //        new Demo().hello("陈含");
//        new Demo().hello();
        // 使用JDBC创建和关闭数据库连接和语句
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl("jdbc:h2:mem:test");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("");
//        dataSource.setTestWhileIdle(true);
//        dataSource.setValidationQuery("SELECT 1");
//
//        DruidPooledConnection connection = dataSource.getConnection();
//        Statement statement = connection.createStatement();
//        statement.execute("select 1");
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT 1");
//      //  System.out.println(statement.execute());
//        int i = 0;
//        statement.close();
//        i = 1;
//        connection.close();
//        i=2;
        //new Demo().hello("chenhan");
    }
}
