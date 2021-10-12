package com.sun.第一季.spring_trans.service.impl;

import com.sun.第一季.spring_trans.service.BookShopService;
import com.sun.第一季.spring_trans.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * create by qiulisun on 2021/10/8.<br>
 */
@Service("cashier")
public class CashierImpl implements Cashier {
    @Autowired
    private BookShopService bookShopService;

    @Transactional
    @Override
    public void checkOut(int userId, List<Integer> isbns) {
        for (Integer isbn : isbns) {
            bookShopService.purchase(userId, isbn);
        }
    }
}
