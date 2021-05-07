package com.sun.rocketMq.顺序消息;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 顺序发送消息 消费者
 * <p>
 * create by qiulisun on 2020/12/13.<br>
 *
 * @author 51050
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        // 创建消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        // 设置nameServer地址
        consumer.setNamesrvAddr("49.234.64.18:9876");
        // 订阅topic和tag
        consumer.subscribe("OrderTopic", "tag");
        // 注册消息监听器,这种监听器从某个指定的队列中消费消息
        MessageListenerOrderly messageListenerOrderly = new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list,
                                                       ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println("线程名称：" + Thread.currentThread().getName() + ":"
                            + new String(messageExt.getBody()));
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        };
        consumer.registerMessageListener(messageListenerOrderly);
        // 启动消费者
        consumer.start();
        System.out.println("消费者启动");
    }
}
