package com.java.controller;

import com.java.config.QQLoginProperties;
import com.java.entity.ThirdPartyUser;
import com.java.utils.QQLoginHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @author: wu
 * @date: 2018年7月25日 下午6:37:04
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private QQLoginProperties qqProperties;

	/**
	 * qq登录回调
	 * @param code
	 * @param state
	 */
	@RequestMapping("/afterLogin")
	public String afterLogin(String code, String state, HttpServletRequest request) {
		try {
			Map<String, String> qqTokenAndOpenid = QQLoginHelper.getQQTokenAndOpenid(qqProperties.getTokenUrl(), qqProperties.getGrantType(), qqProperties.getClientId(), qqProperties.getClientSecret(),
					code, qqProperties.getRedirectUri(), qqProperties.getOpenIdUrl());
			String openId = qqTokenAndOpenid.get("openId");
			String token = qqTokenAndOpenid.get("accessToken");
			ThirdPartyUser user = QQLoginHelper.getQQUserinfo(qqProperties.getUserInfoUrl(),openId,token,qqProperties.getClientId());
			System.out.println("------user:"+user.toString());
			request.getSession().setAttribute("user",user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	@RequestMapping("/loginout")
	public String LoginOut(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "index";
	}
	
}
