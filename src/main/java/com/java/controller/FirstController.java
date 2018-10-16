/**    
 * @Package: com.java.controller 
 * @author: wujb   
 * @date: 2018年6月26日 下午5:07:28 
 */
package com.java.controller;
import com.java.util.IpUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/** 
 * @ClassName: FirstController 
 * @Description: TODO
 * @author: wujb
 * @date: 2018年6月26日 下午5:07:28  
 */
@Controller
@Log4j2
public class FirstController {

	private static int a = 1;
	
	@RequestMapping("/")
    public String file(HttpServletRequest request,Model model){
		log.info("---------第"+(a++)+"个人:"+ IpUtil.getIpAddr(request));
        return "index"; 
    }
	
	/*
     * 获取file.html页面
     */
    @RequestMapping("file")
    public String file(Model model){
        return "file";
    }
	
	@RequestMapping("love")
	public String index() {
		return "love";
	}
	
    /*
     * 获取multifile.html页面
     */
    @RequestMapping("multifile")
    public String multifile(){
        return "multifile";
    }

    @RequestMapping("music")
	public String music() {
		return "musicdownload";
	}
    
    @RequestMapping("kl")
   	public String kl() {
   		return "keli";
   	}
    
    @RequestMapping("xnyh")
   	public String xnyh() {
   		return "新年烟花";
   	}
    
    @RequestMapping("ygdbns")
   	public String ygdbns() {
   		return "一个都不能死";
   	}
    
    @RequestMapping("love1")
   	public String love1() {
   		return "love1";
   	}
    
    @RequestMapping("zkdz")
   	public String zkdz() {
   		return "砖块堆栈";
   	}
}
