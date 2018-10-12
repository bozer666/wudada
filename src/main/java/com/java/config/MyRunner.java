package com.java.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: MyRunner 
 * @Description: TODO
 * @author: wu
 * @date: 2018年7月24日 下午4:07:04  
 */
@Component
@Order(1)
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	private ServletContext context;
	@Value("${BASE_URL}")
	private String BASE_URL;

	@Override
	public void run(String... arg0) throws Exception {
		context.setAttribute("BASE_URL", BASE_URL);
	}

}
