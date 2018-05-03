package com.zyf.java.jmx;

import javax.management.*;
import java.util.Set;

/**
 * @Author zyf
 * @CreateAt 2018/5/3 下午5:45
 */
public class HelloWorldAgent {

    private MBeanServer mBeanServer;

    public HelloWorldAgent() {
        this.mBeanServer = MBeanServerFactory.createMBeanServer("helloworld");

        HelloWorld helloWorld = new HelloWorld();
        ObjectName objectName = null;
        try {
            objectName = new ObjectName("helloworld:name=hello");
            mBeanServer.registerMBean(helloWorld, objectName);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        HelloWorldAgent agent = new HelloWorldAgent();

        agent.mBeanServer.invoke(new ObjectName("helloworld:name=hello"), "f", null, null);
    }
}
