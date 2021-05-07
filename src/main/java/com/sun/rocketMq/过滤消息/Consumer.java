package com.sun.rocketMq.过滤消息;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 过滤消息，有tag过滤和sql过滤两种方式
 * tag过滤可以使用正则表达式过滤
 * <p>
 * create by qiulisun on 2020/12/13.<br>
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
//        1.创建消费者Consumer，制定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
//        2.指定Nameserver地址
        consumer.setNamesrvAddr("49.234.64.18:9876");
//        3.订阅主题Topic和Tag
        // 根据tag过滤
        consumer.subscribe("filterTopic", "tag1 || tag2");
        // 根据sql过滤
        consumer.subscribe("filterTopic", MessageSelector.bySql("i>5"));
//        4.设置回调函数，处理消息
        MessageListenerConcurrently messageListenerConcurrently = new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                            ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println("线程名称：" + Thread.currentThread().getName() + ", 内容："
                            + new String(messageExt.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        };
//        5.启动消费者consumer
        consumer.start();
    }
}
