package com.java.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wu
 * @Description:
 * @Title: ThreadServiceImplTest
 * @date 2018-9-25 10:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadServiceImplTest {
    @Autowired
    private ThreadServiceImpl threadService;

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始------------");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束------------");
    }

    @Test
    public void thread1() {
        for (int i = 1;i<100;i++) {
            threadService.thread1();
        }
    }

}