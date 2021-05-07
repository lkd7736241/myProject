package com.sun.rocketMq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送异步消息
 * <p>
 * create by qiulisun on 2020/12/12.<br>
 * @author 51050
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        // 设置nameServer的地址
        producer.setNamesrvAddr("49.234.64.18:9876");
        // 3.启动producer
        producer.start();
        // 设置消息重发
        producer.setRetryTimesWhenSendAsyncFailed(1);
        for (int i = 0; i < 10; i++) {
            // 4.创建消息对象，指定主题Topic、Tag和消息体
            Message message = new Message("base", "tag2", ("hello world" + i).getBytes());
            // 5.发送消息
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("返回状态：" + sendResult.getSendStatus() + ", id:" + sendResult.getMsgId() +
                            ", queueID:" + sendResult.getMessageQueue().getQueueId());
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("发送失败，错误信息：" + throwable.getMessage());
                }
            });
        }
        // 6.关闭生产者producer
        producer.shutdown();
    }
}
