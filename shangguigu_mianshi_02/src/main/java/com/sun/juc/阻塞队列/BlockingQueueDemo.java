package com.sun.juc.阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 * ArrayBlockingQueue:是一个基于数组结构的有界阻塞队列，此队列按FIFO原则对元素进行排序
 * LinkedBlockingQueue:是一个基于链表结构的阻塞队列，此队列按FIFO排序元素，吞吐量高于ArrayBlockingQueue
 * SynchronousQueue：一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移出操作，
 * 否则插入操作一直处于阻塞状态，吞吐量通常要高
 * <p>
 * 提问：队列阻塞有没有好的一面？不得不阻塞时你如何管理
 * <p>
 * create by qiulisun on 2021/10/21.<br>
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

//        addAndRemoveAndElement(blockingQueue);

//        offerAndPollAndPeek(blockingQueue);

//        putAndTake(blockingQueue);

//        offerAndPollTimeOut(blockingQueue);

        // 使用方式与arrayBlockingQueue相类似
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(3);

        System.out.println(linkedBlockingQueue.add("a"));
        System.out.println(linkedBlockingQueue.add("b"));
        System.out.println(linkedBlockingQueue.add("c"));
        System.out.println(linkedBlockingQueue.add("d"));
    }

    /**
     * 与offer和poll操作一样，但当遇到队列超出限制或队列为空的情况会先等待，之后再返回结果
     *
     * @param blockingQueue
     * @throws InterruptedException
     */
    private static void offerAndPollTimeOut(ArrayBlockingQueue<String> blockingQueue) throws InterruptedException {
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
    }

    /**
     * put、take 操作
     * 若put时元素个数超出队列限制，会一直阻塞
     * 若take时队列已经为空，会一直阻塞
     *
     * @param blockingQueue
     * @throws InterruptedException
     */
    private static void putAndTake(ArrayBlockingQueue<String> blockingQueue) throws InterruptedException {
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take());
    }

    /**
     * offer、poll、peek操作
     * offer添加元素、poll移出元素、peek返回队首元素
     * offer时超出队列元素个数返回false
     * poll时队列为空则返回null
     * peek时队列为空则返回null
     *
     * @param blockingQueue
     */
    private static void offerAndPollAndPeek(ArrayBlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    /**
     * add 和 remove操作
     * 若添加的元素超出队列限制，或移出的元素时队列已经为空，则抛出异常
     * <p>
     * element()方法为取出队首元素，若队列为空则抛出异常
     *
     * @param blockingQueue
     */
    private static void addAndRemoveAndElement(ArrayBlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.element());
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
    }
}
