package com.sun.rocketMq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * create by qiulisun on 2020/12/12.<br>
 *
 * @author 51050
 */
public class OneWayProducer {
    public static void main(String[] args) throws Exception {
        // 1.创建消息生产者producer，并制定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 2.指定Nameserver地址
        producer.setNamesrvAddr("49.234.64.18:9876");
        // 3.启动producer
        producer.start();
        for (int i = 0; i < 10; i++) {
            // 4.创建消息对象，指定主题Topic、Tag和消息体
            Message message = new Message("base", "tag1", ("hello world" + i).getBytes());
            // 5.发送消息
            producer.sendOneway(message);
        }
        // 6.关闭生产者producer
        producer.shutdown();
    }
}
