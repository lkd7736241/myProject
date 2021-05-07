package com.sun.NIO通信;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * create by qiulisun on 2020/12/2.<br>
 */
public class ChannelDemo {
    public static void main(String[] args) throws Exception {
        // 创建通道
        FileInputStream fileInputStream = new FileInputStream("F:\\java学习\\io.pdf");
        FileChannel channel = fileInputStream.getChannel();
//        FileChannel fileChannel = FileChannel.open(Paths.get(""), StandardOpenOption.WRITE);

        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);

        // 分散读取 将一个通道中的数据写入多个缓冲区
        ByteBuffer[] buffers = {buffer1, buffer2};
        channel.read(buffers);

        for (ByteBuffer buffer : buffers) {
            buffer.flip();
        }

        byte[] array1 = buffers[0].array();
        byte[] array2 = buffers[1].array();

        System.out.println(new String(array1, 0, array1.length));
        System.out.println("==============================");
        System.out.println(new String(array2, 0, array2.length));

        // 聚集写入 将多个缓冲区的数据写入一个通道
        RandomAccessFile file = new RandomAccessFile("", "rw");
        FileChannel outChannel = file.getChannel();
        outChannel.write(buffers);
    }
}
