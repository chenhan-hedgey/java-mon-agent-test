package cn.chenhan.tools.agent.ds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chenhan
 * @Description: 数据库信息
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/25 1:38
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseInfo {
    /**
     * 连接驱动类
     */
    private String driverClassName;
    /**
     * 数据库url
     */
    private String url;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
