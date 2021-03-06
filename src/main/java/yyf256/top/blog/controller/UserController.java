package yyf256.top.blog.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yyf256.top.blog.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserInfo")
	public Map<String,Object> getUserInfo(){
		return userService.getUserInfo();
	}
	
	@RequestMapping("/getUserLogo")
	public Map<String,Object> getUserLogo(){
		return userService.getUserLogo();
	}
	
	@RequestMapping("/getPhotoAndTips")
	public Map<String,Object> getPhotoAndTips(){
		return userService.getPhotoAndTips();
	}
	
	@RequestMapping("/getConnectInfo")
	public Map<String,Object> getConnectInfo(){
		return userService.getConnectInfo();
	}
	
	@RequestMapping("/getNearlyMoods")
	public Map<String,Object> getNearlyMoods(){
		return userService.getNearlyMoods(3);
	}
	
	@RequestMapping("/getAnnouncement")
	public Map<String,Object> getAnnouncement(){
		return userService.getConfigValue("Announcement");
	}
	
	@RequestMapping("/getAlipay")
	public Map<String,Object> getAlipay(){
		return userService.getConfigValue("PayAli");
	}
	
	@RequestMapping("/getWechatpay")
	public Map<String,Object> getWechatpay(){
		return userService.getConfigValue("PayWechat");
	}
	
//	public Map<String,Object> sendRegisterCode(String emailAddress){
//		
//	}
}
