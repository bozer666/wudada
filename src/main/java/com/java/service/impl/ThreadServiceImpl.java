package com.java.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author wu
 * @Description:
 * @Title: ThreadServiceImpl
 * @date 2018-9-25 10:43
 */
@Service
@Slf4j
public class ThreadServiceImpl {

    @Async
    public void thread1(){
        log.info("11111111111");
    }

    @Async
    public void thread2(){
        System.out.println("线程22222222222");
    }
}
