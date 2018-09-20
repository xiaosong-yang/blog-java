package yyf256.top.blog.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.mysql.fabric.xmlrpc.base.Data;

import yyf256.top.blog.bean.CodeCache;
import yyf256.top.blog.model.UserInfo;
import yyf256.top.blog.service.UserService;
@Component
public class SystemConfig implements ApplicationContextAware{
	
	private static ApplicationContext application;
	
	private static UserInfo userInfo;
	
	private static Map<String,String> systemConfigs;
	
	/**
	 * 注册验证码的缓存
	 */
	private static Map<String,CodeCache> code=new HashMap<>();
	/**
	 * 当前时间
	 */
	private static Date today=new Date();
	
//	private static int countdayCount=
	public static void insertCodeCache(String email,String code){
		
	}
	
	public static void setUserInfo(UserInfo userInfo){
		SystemConfig.userInfo=userInfo;
	}

	@Override
	public void setApplicationContext(ApplicationContext application) throws BeansException {
		SystemConfig.application = application;
	}
	
	/**
	 * 获取用户信息
	 * @return
	 */
	public static UserInfo getUserInfo(){
		if(userInfo==null){
			UserService userSerivce=application.getBean(UserService.class);
			userInfo= userSerivce.getUserInfoDirect();
		}
		return userInfo;
	}
	
	/**
	 * 获取系统配置
	 */
	public static Map<String,String> getSystemConfigs(){
		if(systemConfigs==null){
			UserService userSerivce=application.getBean(UserService.class);
			systemConfigs=userSerivce.getSystemConfigs();
		}
		return systemConfigs;
	}
	
}
