package yyf256.top.blog.service;

import java.util.Map;

import yyf256.top.blog.model.UserInfo;

public interface UserService {
	
	/**
	 * 从系统配置中获取用户信息,如果系统配置中没有，则会自动从数据库中获取
	 */
	public Map<String,Object> getUserInfo();
	
	/**
	 * 直接从数据库中获取用户信息
	 * @return
	 */
	public UserInfo getUserInfoDirect();
}
