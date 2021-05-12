package com.lemon.java;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lemon
 * @since 2021-05-07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
@ActiveProfiles("BeanTest")
public class BaseTest {
    private Long timeGap = 0L;

    @Before
    public void init() {
        timeGap = System.currentTimeMillis();
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        timeGap = System.currentTimeMillis() - timeGap;
        System.out.println("测试结束-----------------:" + timeGap);
    }
}
