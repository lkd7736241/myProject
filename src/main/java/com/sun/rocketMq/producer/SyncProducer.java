package com.sun.rocketMq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * 发送同步消息
 *
 * create by qiulisun on 2020/12/11.<br>
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
//        1.创建消息生产者producer，并制定生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
//        2.指定Nameserver地址
//        producer.setNamesrvAddr("172.17.0.8:10911");
        producer.setNamesrvAddr("localhost:9876");
        producer.setVipChannelEnabled(false);
//        3.启动producer
        producer.start();
        for (int i = 0; i < 10; i++) {
//        4.创建消息对象，指定主题Topic、Tag和消息体
            /**
             * 参数一：消息主题topic
             * 参数二：消息tag
             * 参数三：消息内容
             */
            Message message = new Message("base", "tag1", ("hello world" + i).getBytes());
//        5.发送消息
            SendResult result = producer.send(message);
            // 返回发送状态
            SendStatus status = result.getSendStatus();
            // 返回发送ID
            String msgId = result.getMsgId();
            // 消息接收队列ID
            int queueId = result.getMessageQueue().getQueueId();
            // 打印返回信息
            System.out.println("返回状态;" + status + ", ID:" + msgId + ", 接收队列ID:" + queueId);
            // 线程睡1秒
            TimeUnit.SECONDS.sleep(1);
        }
//        6.关闭生产者producer
        producer.shutdown();
    }
}
