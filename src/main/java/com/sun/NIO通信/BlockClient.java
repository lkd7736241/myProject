package com.sun.NIO通信;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;

/**
 * nio阻塞客户端
 *
 * create by qiulisun on 2020/12/2.<br>
 */
public class BlockClient {
    public static void main(String[] args) throws Exception {
        // 1.获取通道
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 6666);
        SocketChannel socketChannel = SocketChannel.open(socketAddress);
        // 2.发送一张图片给服务端
        FileChannel fileChannel = FileChannel.open(Paths.get("F:\\java学习\\tomcat.jpg"));
        // 3.初始化缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 4.循环读取写入
        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        // 5.关闭流
        fileChannel.close();
        socketChannel.close();
    }
}
