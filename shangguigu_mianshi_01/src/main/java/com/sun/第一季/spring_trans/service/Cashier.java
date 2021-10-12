package com.sun.第一季.spring_trans.service;

import java.util.List;

/**
 * create by qiulisun on 2021/10/8.<br>
 */
public interface Cashier {

    /**
     * 去结账
     *
     * @param userId
     * @param isbns
     */
    void checkOut(int userId, List<Integer> isbns);
}
