package com.sun.spring.impl;

import com.sun.spring.CalcService;
import org.springframework.stereotype.Service;

/**
 * create by qiulisun on 2021/9/26.<br>
 */
@Service
public class CalcServiceImpl implements CalcService {
    @Override
    public int div(int x, int y) {
        int result = x / y;
        System.out.println("======CalcServiceImpl被调用了，我们的计算结果：" + result);
        return result;
    }
}