package com.sun.spring;

import com.sun.spring.service.CalcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 *
 * create by qiulisun on 2021/12/15.<br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest {
    @Autowired
    private CalcService calcService;

    @Test
    public void testAop() {
        System.out.println("Spring版本：" + SpringVersion.getVersion() + "\t" + "SpringBoot版本：" + SpringBootVersion.getVersion());
        System.out.println();
        calcService.div(10, 2);
    }
}
