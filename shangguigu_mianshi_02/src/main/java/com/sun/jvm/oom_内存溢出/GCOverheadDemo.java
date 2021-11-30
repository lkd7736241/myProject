package com.sun.jvm.oom_内存溢出;

import java.util.ArrayList;
import java.util.List;

/**
 * 将生成的字符串放到字符串常量池中
 * <p>
 * java.lang.OutOfMemoryError:GC overhead limit exceeded
 * <p>
 * GC回收时间过长时会抛出0utOfMemroyError。过长的定义是，超过98%的时间用来做GC并且回收了不到2%的堆内存
 * 连续多次GC都只回收了不到2%的极端情况下才会抛出。不抛出GC overhead Limit 错误会造成：
 * GC清理的这么点内存很快会再次填满，迫使GC再次执行，这样就形成恶性循环，CPU使用孩一直是100%，而GC却没有任何成效
 * <p>
 * create by qiulisun on 2021/10/26.<br>
 */
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("**************i:" + i);
            e.printStackTrace();
            throw e;
        }
    }
}
