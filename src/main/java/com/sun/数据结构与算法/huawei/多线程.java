package com.sun.数据结构与算法.huawei;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create by qiulisun on 2020/11/27.<br>
 */
public class 多线程 {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    static Condition condition3 = lock.newCondition();
    static Condition condition4 = lock.newCondition();
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            count = 0;

            Thread thread1 = getThread1(num);

            Thread thread2 = getThread2(num);

            Thread thread3 = getThread3(num);

            Thread thread4 = getThread4(num);

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
        }


    }

    private static Thread getThread4(int num) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < num; i++) {
                        while (count % 4 != 3) {
                            condition4.await();
                        }
                        System.out.print("D");
                        count++;
                        condition1.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
    }

    private static Thread getThread3(int num) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < num; i++) {
                        while (count % 4 != 2) {
                            condition3.await();
                        }
                        System.out.print("C");
                        count++;
                        condition4.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
    }

    private static Thread getThread2(int num) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < num; i++) {
                        while (count % 4 != 1) {
                            condition2.await();
                        }
                        System.out.print("B");
                        count++;
                        condition3.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
    }

    private static Thread getThread1(int num) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < num; i++) {
                        while (count % 4 != 0) {
                            condition1.await();
                        }
                        System.out.print("A");
                        count++;
                        condition2.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        return thread1;
    }
}


