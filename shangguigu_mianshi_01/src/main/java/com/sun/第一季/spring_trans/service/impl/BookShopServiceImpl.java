package com.sun.第一季.spring_trans.service.impl;

import com.sun.第一季.spring_trans.dao.BookShopDao;
import com.sun.第一季.spring_trans.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Transactional 该注解可以添加到类上，也可以添加到方法上
 * 如果添加到类上，那么类中所有的方法都添加上了事务
 * 如果添加到方法上，只有添加了该注解的方法才添加了事务
 * <p>
 * create by qiulisun on 2021/10/8.<br>
 */
@Transactional
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 事务的属性：
     * 1.★propagation：用来设置事务的传播行为
     * 事务的传播行为：一个方法运行在了一个开启了事务的方法中时，当前方法是使用原来的事务还是开启一个新的事务
     * -Propagation.REQUIRED：默认值，使用原来的事务
     * -Propagation.REQUIRES_NEW：将原来的事务挂起，开启一个新的事务
     * 2.★isolation：用来设置事务的隔离级别
     * -Isolation.REPEATABLE_READ：可重复读，MySQL默认的隔离级别
     * -Isolation.READ_COMMITTED：读已提交，Oracle默认的隔离级别，开发时通常使用的隔离级别
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    @Override
    public void purchase(int userId, int isbn) {
        //1. 获取要买的图书的价格
        double bookPrice = bookShopDao.getBookPriceByIsbn(isbn);
        //2. 更新图书的库存
        bookShopDao.updateBookStock(isbn);
        //3. 更新用户的余额
        bookShopDao.updateAccountBalance(userId, bookPrice);
    }
}
