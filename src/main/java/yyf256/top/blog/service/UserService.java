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
	
	/**
	 * 获取用户logo 
	 * @return
	 */
	public Map<String,Object> getUserLogo();
	
	/**
	 * 获取头像和标签
	 */
	public Map<String,Object> getPhotoAndTips();
	
	/**
	 * 获取联系方式
	 * @return
	 */
	public Map<String,Object> getConnectInfo();
	
	/**
	 *	获取最近的心情列表 
	 * @param count 列数
	 * @return
	 */
	public Map<String,Object> getNearlyMoods(int count);
	
	/**
	 * 获取所有系统配置
	 * @return
	 */
	public Map<String,String> getSystemConfigs();
	
	/**
	 * 根据key获取系统配置
	 * @param key
	 * @return
	 */
	public Map<String,Object> getConfigValue(String key);
}
