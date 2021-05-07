package com.sun;

import org.openjdk.jol.info.ClassLayout;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(2);
//        list.add(1);
//
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
    }
}
