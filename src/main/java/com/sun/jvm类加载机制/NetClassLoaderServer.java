package com.sun.jvm类加载机制;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 网络类加载器
 * <p>
 * create by qiulisun on 2020/12/4.<br>
 * @author 51050
 */
public class NetClassLoaderServer {
    public static void main(String[] args) throws Exception {
        // 绑定到本地的9999端口进行监听
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("开启网络客户端");
        // 进入阻塞状态，等待客户端连接
        Socket client = serverSocket.accept();
        // 获取本地字节文件
        File file = new File("D:\\IntelliJIDEA-workspace\\myProject\\src\\main\\java\\com\\sun\\vo"
                + File.separator + "ListNode.java");
        // 获取文件输入流
        FileInputStream inputStream = new FileInputStream(file);
        // 获取客户端的输出流
        OutputStream outputStream = client.getOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, data.length);
        }
        // 关闭服务
        client.shutdownOutput();
        serverSocket.close();
    }
}
