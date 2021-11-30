package com.sun.jvm.jvm常用参数;

import java.util.concurrent.TimeUnit;

/**
 * create by qiulisun on 2021/10/25.<br>
 */
public class HelloGC {
    public static void main(String[] args) {
        System.out.println("hello gc");

//        List<VirtualMachineDescriptor> vms = VirtualMachine.list();

//        System.out.println("hello jvm");

        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
