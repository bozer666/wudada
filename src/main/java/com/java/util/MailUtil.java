package com.java.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.java.config.Config;

/** 
 * @ClassName: MailUtil 
 * @Description: TODO
 * @author: wu
 * @date: 2018年7月20日 下午3:59:42  
 */
@Component
public class MailUtil {
	
	@Autowired
	private JavaMailSender jms;
	
	private static MailUtil mailUtil;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@PostConstruct
	public void inti() {
		mailUtil=this;
		mailUtil.jms=this.jms;
	}
	
	/**
	 *  发送邮件
	 * @Title: sendMail 
	 * @param from 发送者邮箱
	 * @param to  接受者邮箱
	 * @param subject  邮件标题
	 * @param text  邮件内容
	 * @return String  返回发送状态
	 * @author wu
	 * @date 2018年7月20日下午5:16:02
	 */
	public static String sendMail(String to,String subject,String text) throws Exception {
			// 建立邮件消息
			SimpleMailMessage mainMessage = new SimpleMailMessage();
			// 发送者
			mainMessage.setFrom(mailUtil.username);
			// 接收者
			mainMessage.setTo(to);
			// 发送的标题
			mainMessage.setSubject(subject);
			// 发送的内容
			mainMessage.setText(text);
			mailUtil.jms.send(mainMessage);
			return "success";
	}

}
