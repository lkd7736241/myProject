package com.sun.rocketMq.事务消息;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 事务性生产者实现类
 * <p>
 * create by qiulisun on 2020/12/14.<br>
 *
 * @author 51050
 */
public class TransactionListenerImpl implements TransactionListener {
    /**
     * 执行本地业务
     *
     * @param message
     * @param o
     * @return commit(成功)、rollbak（回滚）、unknown（不确定）
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        System.out.println("执行本地事务");
        return LocalTransactionState.UNKNOW;
    }

    /**
     * 检查本地事务执行结果
     *
     * @param messageExt
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        return null;
    }
}
