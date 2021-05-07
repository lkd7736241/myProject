package com.sun.NIO通信;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * nio阻塞服务端
 *
 * create by qiulisun on 2020/12/2.<br>
 */
public class BlockServer {
    public static void main(String[] args) throws Exception {
        // 1.获取通道
        ServerSocketChannel server = ServerSocketChannel.open();
        // 2.获取到的文件写入通道，将客户端传入的文件写入指定的路径
        FileChannel fileChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        // 3.绑定链接
        InetSocketAddress socketAddress = new InetSocketAddress(6666);
        server.bind(socketAddress);
        // 4.获取客户端的链接（阻塞的）
        SocketChannel client = server.accept();
        // 5.初始化缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 6.循环读取写入
        while (client.read(byteBuffer) != -1) {
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        // 7.关闭通道
        fileChannel.close();
        client.close();
        server.close();
    }
}
