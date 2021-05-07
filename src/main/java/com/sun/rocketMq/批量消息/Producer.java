package com.sun.rocketMq.批量消息;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量发送消息 生产者 （消费者不用做修改）
 * 消息体不能大于4M
 * <p>
 * create by qiulisun on 2020/12/13.<br>
 * @author 51050
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        // 创建生产者对象
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置nameServer地址
        producer.setNamesrvAddr("49.234.64.18:9876");
        // 启动生产者
        producer.start();

        // 创建消息对象 （批量发送创建多条）
        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("bath", "tag", ("hello world" + i).getBytes());
            messageList.add(message);
        }
        // 发送
        producer.send(messageList);
        // 关闭生产者
        producer.shutdown();
    }
}
