package com.java.controller;

import com.alibaba.fastjson.JSON;
import com.java.model.Cron;
import com.java.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wu
 * @Description:
 * @Title: CronController
 * @date 2018-9-20 15:24
 */
@Controller
@RequestMapping("cron")
public class CronController {

    @Autowired
    private CronService cronService;

    @RequestMapping("list")
    @ResponseBody
    public String getList(Cron cron){
        try {
            return JSON.toJSONString(cronService.findCronList(cron));
        } catch (Exception e) {
            e.printStackTrace();
            return "error:"+e;
        }
    }
}
