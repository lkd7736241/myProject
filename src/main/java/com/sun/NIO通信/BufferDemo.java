package com.sun.NIO通信;

import java.nio.ByteBuffer;

/**
 * create by qiulisun on 2020/12/2.<br>
 */
public class BufferDemo {
    public static void main(String[] args){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 初始时的核心变量
        // limit：缓冲区里数据总数
        System.out.println("初始，limit ： " + buffer.limit());
        // position: 下一个要被读或者写的数据的位置
        System.out.println("初始，position ： " + buffer.position());
        // capacity: 缓冲区能够容纳的数据的最大值
        System.out.println("初始，capacity ： " + buffer.capacity());
        // mark:备忘录，上一次操作的记录
        System.out.println("初始，mark ： " + buffer.mark());

        System.out.println("===========================");

        // 添加数据到缓冲区
        String str = "111";
        buffer.put(str.getBytes());

        // 添加数据之后的核心变量
        System.out.println("添加变量后，limit ： " + buffer.limit());
        System.out.println("添加变量后，position ： " + buffer.position());
        System.out.println("添加变量后，capacity ： " + buffer.capacity());
        System.out.println("添加变量后，mark ： " + buffer.mark());

        System.out.println("===========================");
        // 切换为读模式
        buffer.flip();
        // 执行flip()后的核心变量
        System.out.println("执行flip()后，limit ： " + buffer.limit());
        System.out.println("执行flip()后，position ： " + buffer.position());
        System.out.println("执行flip()后，capacity ： " + buffer.capacity());
        System.out.println("执行flip()后，mark ： " + buffer.mark());

        System.out.println("===========================");
        // 获取缓冲区的数据
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));

        System.out.println("===========================");
        // 获取数据后的核心变量
        System.out.println("获取数据后，limit ： " + buffer.limit());
        System.out.println("获取数据后，position ： " + buffer.position());
        System.out.println("获取数据后，capacity ： " + buffer.capacity());
        System.out.println("获取数据后，mark ： " + buffer.mark());

        System.out.println("===========================");
        // 将缓冲区的数据清空，再进入写模式
        buffer.clear();
        // 获取清空后的核心变量
        System.out.println("获取清空后，limit ： " + buffer.limit());
        System.out.println("获取清空后，position ： " + buffer.position());
        System.out.println("获取清空后，capacity ： " + buffer.capacity());
        System.out.println("获取清空后，mark ： " + buffer.mark());
    }
}
