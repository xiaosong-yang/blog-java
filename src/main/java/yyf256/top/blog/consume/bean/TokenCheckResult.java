package yyf256.top.blog.consume.bean;

import java.util.Map;

public class TokenCheckResult {
	/**
	 * 是否成功
	 */
	private boolean isCorrect;
	/**
	 * 返回结果，如果成功不用传入改参数
	 */
	private Map<String,Object> result;
	/**
	 * 传入正确后返回新的token，确保能重新录入数据
	 */
	private String newToken;
	
	/**
	 * 正确不需要传入任何参数
	 */
	public TokenCheckResult(String newToken){
		this.isCorrect=true;
		this.newToken=newToken;
	}
	/**
	 * 传入结果默认为不正确
	 * @param result
	 */
	public TokenCheckResult(Map<String, Object> result) {
		this.isCorrect=false;
		this.result = result;
	}
	
	public boolean isCorrect() {
		return isCorrect;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public String getNewToken() {
		return newToken;
	}
	
	
	
}
