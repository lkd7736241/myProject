package com.sun.多线程.ThreadLocal;

/**
 * create by qiulisun on 2020/12/20.<br>
 * @author 51050
 */
public class ThreadLocalDemo {
    ThreadLocal<Long> idLocal = new ThreadLocal<Long>();
    ThreadLocal<String> nameLocal = new ThreadLocal<String>();

    public static void main(String[] args) throws Exception {
        final ThreadLocalDemo demo = new ThreadLocalDemo();

        demo.set();
        System.out.println(demo.getId());
        System.out.println(demo.getName());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                demo.set();
                System.out.println(demo.getId());
                System.out.println(demo.getName());
            }
        });
        thread.start();
        thread.join();

        System.out.println(demo.getId());
        System.out.println(demo.getName());
    }

    public void set() {
        idLocal.set(Thread.currentThread().getId());
        nameLocal.set(Thread.currentThread().getName());
    }

    public long getId() {
        return idLocal.get();
    }

    public String getName() {
        return nameLocal.get();
    }
}
