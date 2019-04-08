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
	
    /**
     *  发送邮件
     * @Title: sendMail 
     * @param emailTo  接受者邮箱
     * @param emailSubject  邮件标题
     * @param emailText  邮件内容
     * @return String  返回发送状态
     * @author wu
     * @date 2018年7月20日下午5:16:02
     */
    public static String sendEmail(String emailTo,String emailSubject,String emailText) throws Exception {
	// 建立邮件消息
	SimpleMailMessage mainMessage = new SimpleMailMessage();
	// 发送者
	mainMessage.setFrom(username);
	// 接收者
	mainMessage.setTo(emailTo);
	// 发送的标题
	mainMessage.setSubject(emailSubject);
	// 发送的内容
	mainMessage.setText(emailText);
	jms.send(mainMessage);
	return "success";
    }
	
    /**
     * 邮件发送对象
     */
    public static JavaMailSender jms;
    
    /**
     * 发送者
     */
    public static String username;
    
    @Autowired
    public void setJms(JavaMailSender jms) {
        this.jms = jms;
    }
    
    @Value("${spring.mail.username}")
    public void setUsername(String username) {
        this.username = username;
    }

}
