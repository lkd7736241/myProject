package com.sun.jvm类加载机制;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义类加载器
 * <p>
 * create by qiulisun on 2020/12/3.<br>
 */
public class FileClassLoader extends ClassLoader {
    private static final String CLASS_FILE_PATH =
            "D:\\IntelliJIDEA-workspace\\myProject\\src\\main\\java\\com\\sun\\vo" + File.separator + "ListNode.java";

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
        //  获取要加载文件的二进制字节输入流对象
        FileInputStream input = new FileInputStream(new File(CLASS_FILE_PATH));
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
