package com.sun.rocketMq.事务消息;

import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.TimeUnit;

/**
 * 事务消息生产者
 * <p>
 * create by qiulisun on 2020/12/14.<br>
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        // 创建事务监听器
        TransactionListener listener = new TransactionListenerImpl();
        // 创建生产者对象 （事务）
        TransactionMQProducer producer = new TransactionMQProducer("group");
        // 设置nameServer地址
        producer.setNamesrvAddr("49.234.64.18:9876");
        // 给生产者添加监听器
        producer.setTransactionListener(listener);
        // 启动生产者
        producer.start();

        for (int i = 0; i < 3; i++) {
            // 创建消息
            Message message = new Message("TransTopic", "tag" + i, "key" + i,
                    ("hello world").getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送
            TransactionSendResult sendResult = producer.sendMessageInTransaction(message, null);
            System.out.println(sendResult.getSendStatus());
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
