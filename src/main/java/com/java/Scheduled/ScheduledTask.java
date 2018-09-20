package com.java.Scheduled;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wu
 * @Description:
 * @Title: ScheduledTask
 * @date 2018-9-20 13:39
 */
@Component
@Configurable
public class ScheduledTask {

    //@Scheduled(cron = "* * * * * ?")
    @Scheduled(fixedRate = 1000*60)
    public void task1() throws Exception{
        System.out.println("任务时间:"+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
    }
}
