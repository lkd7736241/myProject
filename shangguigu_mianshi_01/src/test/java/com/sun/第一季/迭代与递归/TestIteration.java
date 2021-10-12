package com.sun.第一季.迭代与递归;

import com.sun.第一季.迭代与递归.Iteration;
import org.junit.Test;

/**
 * create by qiulisun on 2021/10/7.<br>
 */
public class TestIteration {
    @Test
    public void test() {
        int res = Iteration.loop(3);
        System.out.println("共有" + res + "种方法");
    }
}
