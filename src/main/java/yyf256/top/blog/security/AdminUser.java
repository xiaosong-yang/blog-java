//package yyf256.top.blog.security;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import common.pnrtec.jupiter.web.security.core.User;
//
//import yyf256.top.blog.config.SystemConfig;
//import yyf256.top.blog.exception.ConfigNullException;
//import yyf256.top.blog.exception.ErrorLoggerFactory;
//
//public class AdminUser implements User{
//
//	private final List<String> authList;
//
//	public AdminUser() {
//		this.authList = new ArrayList<>();
//		for(String auth:SecurityContants.AUTH_LIST)
//		authList.add(auth);
//	}
//
//	@Override
//	public List<String> getUserAuthList() {
//		return authList;
//	}
//
//	@Override
//	public String getUserId() {
//		try {
//			return SystemConfig.getAccountName();
//		} catch (ConfigNullException e) {
//			ErrorLoggerFactory.getInstance().LoggerException(e);
//		}
//		return null;
//	}
//
//	@Override
//	public String getUserName() {
//		//这个项目中用户名和用户id是同一个
//		try {
//			return SystemConfig.getAccountName();
//		} catch (ConfigNullException e) {
//			ErrorLoggerFactory.getInstance().LoggerException(e);
//		}
//		return null;
//	}
//
//	@Override
//	public String getUserPwd() {
//		try {
//			return SystemConfig.getAccountPwd();
//		} catch (ConfigNullException e) {
//			ErrorLoggerFactory.getInstance().LoggerException(e);
//		}
//		return null;
//	}
//
//}
