package com.sun.rocketMq.顺序消息;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * 顺序发送消息 生产者
 * 将一个业务的消息发送到一个队列当中
 * <p>
 * create by qiulisun on 2020/12/13.<br>
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        // 创建生产者对象
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置nameServer地址
        producer.setNamesrvAddr("49.234.64.18:9876");
        // 启动生产者对象
        producer.start();
        // 构建消息集合（假数据）
        List<OrderStep> orderSteps = OrderStep.buildOrders();

        for (int i = 0; i < orderSteps.size(); i++) {
            OrderStep order = orderSteps.get(i);
            Message message = new Message("OrderTopic", "tag", i + "", order.toString().getBytes());

            /**
             * 队列选择器
             */
            MessageQueueSelector messageQueueSelector = new MessageQueueSelector() {
                /**
                 * 相同订单的操作发送的同一个队列
                 *
                 * @param list      rocketMq中的队列集合
                 * @param message   消息对象（即send方法传入的第一个参数）
                 * @param o         业务标志的参数(即send方法传入的第三个参数)
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    long orderId = (long) o;
                    // 对同一个订单的操作，orderid相同，所以取到的index也是相同的
                    long index = orderId % list.size();
                    return list.get((int) index);
                }
            };

            /**
             * 参数一：消息对象
             * 参数二：消息队列的选择器
             * 参数三：消息队列的id，业务id
             */
            producer.send(message, messageQueueSelector, order.getOrderId());
        }
        // 关闭生产者
        producer.shutdown();
    }
}
