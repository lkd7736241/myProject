package com.sun.NIO通信;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * nio非阻塞客户端
 *
 * create by qiulisun on 2020/12/3.<br>
 */
public class NonBlockClient {
    public static void main(String[] args) throws  Exception {
        // 1.获取通道
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 6666);
        SocketChannel socketChannel = SocketChannel.open(socketAddress);
        // 1.1 切换为非阻塞模式
        socketChannel.configureBlocking(false);
        // 2.发送一张图片给服务端
        FileChannel fileChannel = FileChannel.open(Paths.get("F:\\java学习\\tomcat.jpg"), StandardOpenOption.READ);
        // 3.初始化缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 4.循环读取写入
        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        // 5. 关闭流
        fileChannel.close();
        socketChannel.close();
    }
}
