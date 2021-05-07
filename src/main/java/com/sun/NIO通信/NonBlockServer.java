package com.sun.NIO通信;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * nio非阻塞客户端
 * <p>
 * create by qiulisun on 2020/12/3.<br>
 */
public class NonBlockServer {
    public static void main(String[] args) throws Exception {
        // 1.获取通道
        ServerSocketChannel server = ServerSocketChannel.open();
        // 2.切换为非阻塞模式
        server.configureBlocking(false);
        // 3.绑定链接
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 6666);
        server.bind(socketAddress);
        // 4.获取选择器
        Selector selector = Selector.open();
        // 4.1 将通道注册到选择器上，指定接收“监听通道”事件
        server.register(selector, SelectionKey.OP_ACCEPT);
        // 5.轮询并获取选择器上已“就绪”的事件,只要select()>0,说明已就绪
        while (selector.select() > 0) {
            // 6.获取当前选择器所有注册的“选择键”（已就绪的监听事件）
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            // 7.获取已就绪的事件（不同的事件做不同的事）
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                // 接收事件就绪
                if (selectionKey.isAcceptable()) {
                    // 8.获取客户端的链接
                    SocketChannel client = server.accept();
                    // 8.1 切换到非阻塞状态
                    client.configureBlocking(false);
                    // 8.2 注册到选择器上
                    client.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) { // 读事件就绪
                    // 9.获取当前选择器就绪状态的通道
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    // 9.1 初始化缓冲器
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    // 9.2 获取文件通道, 将客户端传来的图片写入本地目录
                    FileChannel fileChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.WRITE,
                            StandardOpenOption.CREATE);
                    while (client.read(byteBuffer) > 0) {
                        byteBuffer.flip();
                        fileChannel.write(byteBuffer);
                        byteBuffer.clear();
                    }
                }
                iterator.remove();
            }
        }
    }
}
