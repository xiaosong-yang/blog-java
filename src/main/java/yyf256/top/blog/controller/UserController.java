package yyf256.top.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yyf256.top.blog.service.TestService;
import yyf256.top.blog.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private TestService testService;
	
	@RequestMapping("/getUserInfo")
	public @ResponseBody Map<String,Object> getUserInfo(){
		return userService.getUserInfo();
//		return testService.test();
	}
}
