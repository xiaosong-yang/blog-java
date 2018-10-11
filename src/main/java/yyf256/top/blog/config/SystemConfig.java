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
import yyf256.top.blog.config.contants.SystemConfigKeyContants;
import yyf256.top.blog.exception.ConfigNullException;
import yyf256.top.blog.exception.ErrorLoggerFactory;
import yyf256.top.blog.exception.ExceptionType;
import yyf256.top.blog.model.UserInfo;
import yyf256.top.blog.service.UserService;
import yyf256.top.blog.util.DateUtil;
import yyf256.top.blog.util.StringUtil;
@Component
public class SystemConfig implements ApplicationContextAware,SystemConfigKeyContants{
	
	private static ApplicationContext application;
	
	private static UserInfo userInfo;
	
	private static Map<String,String> systemConfigs;
	
	public static final String ROOT_PATH="/blog";
	
	/**
	 * 注册验证码的缓存
	 */
	private static Map<String,CodeCache> codes=new HashMap<>();
	/**
	 * 当前时间
	 */
	private static Date endTime=new Date();
	/**
	 * 当日邮件发送书
	 */
	private static Integer todaySendEmailCount=0;
	/**
	 * 最多可发邮件数量，默认为-1，需要从数据库中读取
	 */
	private static int maxSendEmailCount=-1;
	
	
	
	
	/**
	 * 	缓存验证码	
	 * @param email
	 * @param code
	 */
	public static void insertCodeCache(String email,String code){
		codes.put(email,new CodeCache(code, new Date()));
	}
	
	/**
	 * 获取每日最大可发送邮件数量
	 * @return
	 */
	public static int geTodayMaxSendEmailCount(){
		if(maxSendEmailCount!=-1){
			return maxSendEmailCount;
		}
		String count=getSystemConfigs().get(DAY_MAX_SEND_MAIL_COUNT);
		if(null!=count && !"".equals(count)){
			maxSendEmailCount=Integer.parseInt(count);
			return maxSendEmailCount;
		}
		return 0;
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
	
	/**
	 * 判断是否还有发送注册码的次数
	 * @return
	 */
	public static boolean isCouldSendRegisterCode(Date sendTime){
		if(sendTime.getTime()<endTime.getTime()){
			if(todaySendEmailCount>=geTodayMaxSendEmailCount()){
				return false;
			}
		}
		endTime=DateUtil.getTomZero(sendTime);
		ClearSendMailCount();
		return true;
	}
	/**
	 * 清零发送邮件的次数
	 * @param count
	 */
	public static void ClearSendMailCount(){
		synchronized (todaySendEmailCount) {
			todaySendEmailCount = 0;
		}
	}
	
	/**
	 *自增发送邮件的次数 
	 */
	public static void AutoIncreaseSendMailCount(){
		synchronized (todaySendEmailCount) {
			todaySendEmailCount++;
		}
	}
	
	/**
	 * 获取系统唯一账户账号
	 * @return 返回账号的字符串
	 * @throws ConfigNullException  账号账号配置不存在异常
	 */
	public static String getAccountName() throws ConfigNullException{
		String adminAccount=getSystemConfigs().get(SystemConfigKeyContants.ADMIN_ACCOUNT);
		if(StringUtil.isEmpty(adminAccount)){
			throw new ConfigNullException("数据库中配置的AdimAccount不存在，请检查数据库config表");
		}else{
			return adminAccount;
		}
	}
	
	/**
	 * 获取系统唯一账户密码
	 * @return 返回密码的字符串
	 * @throws ConfigNullException  账号密码配置不存在异常
	 */
	public static String getAccountPwd() throws ConfigNullException{
		String adminPwd=getSystemConfigs().get(SystemConfigKeyContants.ADMIN_PWD);
		if(StringUtil.isEmpty(adminPwd)){
			throw new ConfigNullException("数据库中配置的AdminPwd不存在，请检查数据库config表");
		}else{
			return adminPwd;
		}
	}
	
	public static void setUserInfo(UserInfo userInfo){
		SystemConfig.userInfo=userInfo;
	}

	@Override
	public void setApplicationContext(ApplicationContext application) throws BeansException {
		SystemConfig.application = application;
	}
}
