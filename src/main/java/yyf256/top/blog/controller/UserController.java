package yyf256.top.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yyf256.top.blog.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserInfo")
	public @ResponseBody Map<String,Object> getUserInfo(){
		return userService.getUserInfo();
	}
	
	@RequestMapping("/getUserLogo")
	public @ResponseBody Map<String,Object> getUserLogo(){
		return userService.getUserLogo();
	}
	
	@RequestMapping("/getPhotoAndTips")
	public @ResponseBody Map<String,Object> getPhotoAndTips(){
		return userService.getPhotoAndTips();
	}
	
	@RequestMapping("/getConnectInfo")
	public @ResponseBody Map<String,Object> getConnectInfo(){
		return userService.getConnectInfo();
	}
	
	@RequestMapping("/getNearlyMoods")
	public @ResponseBody Map<String,Object> getNearlyMoods(){
		return userService.getNearlyMoods(3);
	}
	
	@RequestMapping("/getAnnouncement")
	public @ResponseBody Map<String,Object> getAnnouncement(){
		return userService.getConfigValue("Announcement");
	}
	
}
