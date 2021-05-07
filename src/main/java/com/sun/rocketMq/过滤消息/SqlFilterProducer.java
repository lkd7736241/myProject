package com.sun.rocketMq.过滤消息;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * create by qiulisun on 2020/12/13.<br>
 *
 * @author 51050
 */
public class SqlFilterProducer {
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
            message.putUserProperty("i", String.valueOf(i));
            // 发送
            producer.send(message);

            TimeUnit.SECONDS.sleep(1);
        }

        // 关闭生产者
        producer.shutdown();
    }
}
