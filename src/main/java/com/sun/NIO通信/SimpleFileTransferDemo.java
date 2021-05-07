package com.sun.NIO通信;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * create by qiulisun on 2020/12/2.<br>
 */
public class SimpleFileTransferDemo {

    public static void main(String[] args) throws Exception {
        SimpleFileTransferDemo test = new SimpleFileTransferDemo();
        File source = new File("F:\\java学习\\大话设计模式(带目录完整版).pdf");
        File ioDes = new File("F:\\java学习\\io.pdf");
        File nioDes = new File("F:\\java学习\\nio.pdf");

        long ioTime = test.transFile(source, ioDes);
        System.out.println("io时间：" + ioTime);
        long nioTime = test.transFileWhitNio(source, nioDes);
        System.out.println("nio时间：" + nioTime);
    }

    private long transFile(File source, File des) throws Exception {
        long startTime = System.currentTimeMillis();
        if (!des.exists()) {
            des.createNewFile();
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        // 将数据源读到的数据写入目的地
        byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private long transFileWhitNio(File source, File des) throws Exception {
        long startTime = System.currentTimeMillis();

        if (!des.exists()) {
            des.createNewFile();
        }

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");

        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);

        // 将通道中的数据写入缓冲区
        while(readChannel.read(byteBuffer) > 0) {
            // 切换缓冲区模式为读取数据
            byteBuffer.flip();
            // 读取缓冲区中的数据并写入通道中
            writeChannel.write(byteBuffer);
            // 清空缓冲区
            byteBuffer.clear();
        }

        writeChannel.close();
        readChannel.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
