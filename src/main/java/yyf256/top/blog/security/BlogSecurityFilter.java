//package yyf256.top.blog.security;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//
//import common.pnrtec.jupiter.web.security.core.AuthConfigListener;
//import common.pnrtec.jupiter.web.security.core.SecurityFilter;
//import common.pnrtec.jupiter.web.security.core.User;
//import common.pnrtec.jupiter.web.security.entity.LoginResult;
//
//import yyf256.top.blog.config.ResponseConfig;
//import yyf256.top.blog.config.SystemConfig;
//import yyf256.top.blog.exception.ConfigNullException;
//import yyf256.top.blog.exception.ErrorLoggerFactory;
//
//@WebFilter("/*")
//public class BlogSecurityFilter extends SecurityFilter{
//
//	@Override
//	protected LoginResult Login(ServletRequest request, ServletResponse response) {
//		String name=request.getParameter("username");
//		String pwd=request.getParameter("password");
//		String realName;
//		String realPwd;
//		LoginResult loginRs=null;
//		try {
//			realName = SystemConfig.getAccountName();
//			realPwd = SystemConfig.getAccountPwd();
//			if(realPwd.equals(pwd) && realName.equals(name)){
//				loginRs=new LoginResult(true, name);
//			}else{
//				Map<String,Object> content=new HashMap<>();
//				content.put(SecurityContants.FAIL_LOGIN_REASON, "账号或密码错误");
//				loginRs=new LoginResult(false, name, content);
//			}
//		} catch (ConfigNullException e) {
//			ErrorLoggerFactory.getInstance().LoggerException(e);
//			Map<String,Object> content=new HashMap<>();
//			content.put(SecurityContants.FAIL_LOGIN_REASON, "系统异常");
//			loginRs=new LoginResult(false, name, content);
//		}
//		return loginRs;
//	}
//
//	@Override
//	public Class<? extends AuthConfigListener> getConfigListenerClass() {
//		return SecurityListener.class;
//	}
//
//	@Override
//	protected User getUser(String userId) {
//		try {
//			if(SystemConfig.getAccountName().equals(userId)){
//				return new AdminUser();
//			}
//		} catch (ConfigNullException e) {
//			ErrorLoggerFactory.getInstance().LoggerException(e);
//		}
//		return null;
//	}
//
//	@Override
//	protected Map<String, Object> returnLogin(LoginResult rs) {
//		Map<String,Object> returnRs=new HashMap<>();
//		if(rs.isVerificateType()){
//			returnRs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
//			returnRs.put(ResponseConfig.RSP_CONTENT,SecurityContants.SUCCESS_LOGIN_RETURN);
//		}else{
//			returnRs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
//			returnRs.put(ResponseConfig.FAIL_REASON,rs.getContent().get(SecurityContants.FAIL_LOGIN_REASON));
//		}
//		return returnRs;
//	}
//
//}
