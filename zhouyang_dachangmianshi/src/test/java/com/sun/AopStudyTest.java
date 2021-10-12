package com.sun;

import com.sun.spring.CalcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * create by qiulisun on 2021/9/26.<br>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AopStudyTest {
    @Autowired
    private CalcService calcService;

    @Test
    public void testAop() {
        System.out.println("spring版本：" + SpringVersion.getVersion() + "\t"
                + "springboot版本：" + SpringBootVersion.getVersion());
        System.out.println();
        calcService.div(10, 2);
    }
}
