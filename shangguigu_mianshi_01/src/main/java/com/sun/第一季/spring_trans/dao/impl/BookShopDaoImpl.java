package com.sun.第一季.spring_trans.dao.impl;

import com.sun.第一季.spring_trans.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * create by qiulisun on 2021/10/8.<br>
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public double getBookPriceByIsbn(int isbn) {
        // 写sql语句
        String sql = "select price from book where isbn = ?";
        Double aDouble = jdbcTemplate.queryForObject(sql, Double.class, isbn);
        return aDouble;
    }

    @Override
    public void updateBookStock(int isbn) {
        String sql = "update book_stock set stock = stock - 1 where isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateAccountBalance(int userId, double bookPrice) {
        String sql = "update account set balance = balance - ? where id = ?";
        jdbcTemplate.update(sql, bookPrice, userId);
    }
}
