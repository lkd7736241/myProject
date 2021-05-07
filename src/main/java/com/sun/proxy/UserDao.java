package com.sun.proxy;

import org.springframework.stereotype.Repository;

/**
 * create by qiulisun on 2018/12/15.<br>
 * @author 51050
 */
@Repository
public class UserDao implements IUser{

    @Override
    public void save() {
            System.out.println("DB:保存用户");
    }
}
