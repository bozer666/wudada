package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.util.MailUtil;

/**
 * @ClassName: MailController
 * @Description: TODO
 * @author: wujb
 * @date: 2018年7月19日 下午4:11:26
 */
@Controller
@RequestMapping("/mail")
public class MailController {
	
	private static Integer count = 1;

	@ResponseBody
	@RequestMapping("/sendScore")
	public String sendMail(String score){
		try {
			return MailUtil.sendMail("1064969858@qq.com", "分数" + count,
					"第" + (count++) + "个人分数: " + score + " 秒");
		} catch (Exception e) {
			e.printStackTrace();
			return "error:"+e.getStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping("/send")
	public String send(){
		try {
			return MailUtil.sendMail("1064969858@qq.com", "哈哈", "哈哈哈哈哈哈哈");
		} catch (Exception e) {
			e.printStackTrace();
			return "error:"+e.getStackTrace();
		}
		
	}
}
