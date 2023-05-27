package com.example.monitoring.model;

/**
 * @Author: chenhan
 * @Description:
 * @ProjectName: java-mon-agent-test
 * @Date: 2023/5/27 12:49
 */
public class Demo {
    String id;
    public void hello(String name){
        System.out.println("hello:" + name);
    }
    public void hello(){
        System.out.println("hello:" + "name");
    }

    public Demo() {
    }

    public Demo(String id) {
        this.id = id;
    }
}
