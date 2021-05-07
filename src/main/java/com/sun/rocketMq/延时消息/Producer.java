package com.sun.rocketMq.延时消息;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * 延时发送消息 生产者 （消费者可以用基本的消费者代码，不需要做修改）
 * <p>
 * create by qiulisun on 2020/12/13.<br>
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        // 创建生产者对象
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置naemServer地址
        producer.setNamesrvAddr("49.234.64.18:9876");
        // 生产者启动
        producer.start();

        for (int i = 0; i < 10; i++) {
            // 创建消息，指定topic，tag，消息体
            Message message = new Message("DelayTopic", "tag", ("hello world" + i).getBytes());
            // 设置消息延迟时间 (rocketMq不支持任意时间的延迟，共有18个延迟等级)
            // private String messageDelayLevel = "1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h";
            message.setDelayTimeLevel(3);
            // 发送
            producer.send(message);

            TimeUnit.SECONDS.sleep(1);
        }

        // 关闭生产者
        producer.shutdown();
    }
}
