/**    
 * @Package: com.java.controller 
 * @author: wujb   
 * @date: 2018年6月26日 下午5:07:28 
 */
package com.java.controller;
import javax.servlet.http.HttpServletRequest;

import com.java.util.IpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @ClassName: FirstController 
 * @Description: TODO
 * @author: wujb
 * @date: 2018年6月26日 下午5:07:28  
 */
@Controller
public class FirstController {
	private static int a = 1;
	
	@RequestMapping("/")
    public String file(HttpServletRequest request){
		System.out.println("---------第"+(a++)+"个人:"+ IpUtil.getIpAddr(request));
        return "index"; 
    }
	
	/*
     * 获取file.html页面
     */
    @RequestMapping("file")
    public String file(Model model){
        return "file";
    }
	
	@RequestMapping("/love")
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
    
    /**
	 * @Title: pub 
	 * @Description: TODO  void
	 * @author wujb
	 * @date 2018年6月28日上午10:30:55
	 */
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
   	public String ygdbns(Model model) {
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

   	@RequestMapping("test")
	@ResponseBody
	public String setA(String a) {
		return a;
	}
}
