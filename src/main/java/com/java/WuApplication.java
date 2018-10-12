/**    
 * @Package: com.java 
 * @author: wu
 * @date: 2018年6月26日 下午5:06:00 
 */
package com.java;

import lombok.extern.java.Log;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: Application
 * @Description: TODO
 * 	 ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @author: wu
 * @date: 2018年6月26日 下午5:06:00
 */
@SpringBootApplication
//@ServletComponentScan
@EnableScheduling
@EnableCaching       //开启缓存
@MapperScan("com.java.mapper")
@EnableAsync    //开启异步多线程
@Log
@EnableTransactionManagement  //事务
public class WuApplication extends SpringBootServletInitializer {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 *            void
	 * @author wu
	 * @date 2018年6月26日下午5:06:00
	 */
	public static void main(String[] args) {
		SpringApplication.run(WuApplication.class, args);
		log.info("========================SpringBoot启动完毕==========================");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WuApplication.class);
	}

}
