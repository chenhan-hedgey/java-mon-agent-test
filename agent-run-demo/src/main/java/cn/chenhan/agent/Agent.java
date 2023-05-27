package cn.chenhan.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.Instrumentation;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/25 22:27
 */
public class Agent {
    private static final Logger logger = LoggerFactory.getLogger(Agent.class);
    public static void premain(String args, Instrumentation inst){
        logger.info("agent is running");
    }
}
