package cn.chenhan.tools.agent.ds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chenhan
 * @Description: 连接池信息
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/25 1:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceInfo {
    /**
     * 最大连接数
     */
    private Integer maxConnections;
    /**
     * 最小空余连接数
     */
    private Integer minIdleConnections;
    /**
     * 初始连接
     */
    private Integer initialConnections;
}
