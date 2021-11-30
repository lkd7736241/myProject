package com.sun.juc.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * create by qiulisun on 2021/10/23.<br>
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        System.out.println("fixed thread pool");
//        fixedThreadPool();

//        System.out.println("single thread pool");
//        singleThreadPool();

        System.out.println("cached thread pool");
        cachedThreadPool();
    }

    /**
     * 自适应线程数量的线程
     * <p>
     * 1. 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     * 2. newCachedThreadPool()将线程池的corePoolSize设置为0，将线程池的maximumPoolSize设置为Integer.MAX_VALUE，
     * 使用的SynchronousQueue，也就是说来了任务就创建线程运行，当线程空闲超过60秒，就销毁线程
     * <p>
     * public static ExecutorService newCachedThreadPool() {
     * return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
     * 60L, TimeUnit.SECONDS,
     * new SynchronousQueue<Runnable>());
     * }
     */
    private static void cachedThreadPool() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    /**
     * 单个线程的线程池
     * <p>
     * 1. 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行
     * 2. newSingleThreadExecutor()将线程池的corePoolSize和maximumPoolSize都设置为1，它使用的LinkedBlockingQueue 阻塞队列
     * <p>
     * public static ExecutorService newSingleThreadExecutor() {
     * return new FinalizableDelegatedExecutorService
     * (new ThreadPoolExecutor(1, 1,
     * 0L, TimeUnit.MILLISECONDS,
     * new LinkedBlockingQueue<Runnable>()));
     * }
     */
    private static void singleThreadPool() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            for (int i = 0; i < 10; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }

    /**
     * 固定线程数量的线程池（自定义线程数量），一般用于用时较长的任务
     * <p>
     * 1. 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     * 2. newFixedThreadPool() 创建的线程池corePoolSize和maximumPoolSize值是相等的，它使用的LinkedBlockingQueue 阻塞队列
     * <p>
     * public static ExecutorService newFixedThreadPool(int nThreads) {
     * return new ThreadPoolExecutor(nThreads, nThreads,
     * 0L, TimeUnit.MILLISECONDS,
     * new LinkedBlockingQueue<Runnable>());
     * }
     */
    private static void fixedThreadPool() {
        // 设置5个线程
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 用try-catch-finally
        // 模拟10个用户来办理业务，每个用户就是一个线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
