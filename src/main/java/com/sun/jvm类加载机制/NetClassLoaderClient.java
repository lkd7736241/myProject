package com.sun.jvm类加载机制;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 网络服务器客户端
 * <p>
 * create by qiulisun on 2020/12/4.<br>
 */
public class NetClassLoaderClient extends ClassLoader {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_POST = 9999;

    public Class<?> loadData(String className) throws Exception {
        byte[] bytes = this.loadFileClassData();
        if (bytes != null) {
            return defineClass(className, bytes, 0, bytes.length);
        }
        return null;
    }

    /**
     * 自定义一个新的方法，将根据给定的文件路径进行加载，为了简化没有进行严格的异常控制
     *
     * @return
     * @throws Exception
     */
    private byte[] loadFileClassData() throws Exception {
        Socket client = new Socket(SERVER_HOST, SERVER_POST);
        //  获取要加载文件的二进制字节输入流对象
        InputStream input = client.getInputStream();
        // 最终要将所有数据保存到内存中，并且要利用字节数组返回
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024 * 1024];
        int len;
        while ((len = input.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        byte[] bosBytes = bos.toByteArray();
        input.close();
        bos.close();
        return bosBytes;
    }
}
