package com.sun.第一季.spring_trans.service;

/**
 * create by qiulisun on 2021/10/8.<br>
 */
public interface BookShopService {
    /**
     * 买东西
     *
     * @param userId
     * @param isbn
     */
    void purchase(int userId, int isbn);
}
