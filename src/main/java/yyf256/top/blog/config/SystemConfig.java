package yyf256.top.blog.config;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import yyf256.top.blog.model.UserInfo;
import yyf256.top.blog.service.UserService;
@Component
public class SystemConfig implements ApplicationContextAware{
	
	private static ApplicationContext application;
	
	private static UserInfo userInfo;
	
	private static Map<String,String> systemConfigs;
	
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