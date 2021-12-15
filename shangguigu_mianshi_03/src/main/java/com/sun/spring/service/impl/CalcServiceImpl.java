package com.sun.spring.service.impl;

import com.sun.spring.service.CalcService;
import org.springframework.stereotype.Service;

/**
 * create by qiulisun on 2021/12/15.<br>
 *
 * @author 51050
 */
@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public int div(int x, int y) {
        int result = x / y;
        System.out.println("=============CalcServiceImpl.div 被调用，结果：" + result);
        return result;
    }
}
