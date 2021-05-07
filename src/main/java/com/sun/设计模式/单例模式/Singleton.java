package com.sun.设计模式.单例模式;

/**
 * create by qiulisun on 2020/11/23.<br>
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    /**
     * 做Doble Check Lock的目的:第一次判断对象为空到申请锁的这段操作，有可能正好别的线程将锁释放
     *
     * @return
     */
    public static Singleton getInstance() {
        // double check lock
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
