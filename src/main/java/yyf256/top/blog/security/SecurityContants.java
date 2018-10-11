package yyf256.top.blog.security;
/**
 * 项目中安全控制的相关常量配置
 * @author addddd
 *
 */
public interface SecurityContants {
	/**
	 * 登录失败原因
	 */
	public static final String FAIL_LOGIN_REASON="failLoginReason";
	/**
	 * 登录成功过的返回内容
	 */
	public static final String SUCCESS_LOGIN_RETURN="恭喜登陆成功";
	/**
	 * 角色列表，当前系统只有一个角色
	 */
	public static final String[] AUTH_LIST=new String[]{"Super_Admin"};
}
