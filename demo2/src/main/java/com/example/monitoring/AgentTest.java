package com.example.monitoring;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/27 11:40
 */

public class AgentTest {

    private void fun1() throws Exception {
        System.out.println("this is fun 1.");
        Thread.sleep(500);
    }

    private void fun2() throws Exception {
        System.out.println("this is fun 2.");
        Thread.sleep(500);
    }

    public static void main(String[] args) throws Exception {
        AgentTest test = new AgentTest();
        test.fun1();
        test.fun2();

    }
}