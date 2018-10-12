package yyf256.top.blog.consume.bean;

import java.util.HashMap;
import java.util.Map;

public class HandleResult {
	/**
	 * 是否处理成功
	 */
	private boolean isSuccess;
	/**
	 * 失败原因
	 */
	private String failReason;
	/**
	 * 其他补充参数
	 */
	private Map<String,Object> otherParams;
	
	/**
	 * 默认成功
	 * failReason为null
	 * otherParams为null
	 */
	public HandleResult() {
		this.isSuccess=true;
		this.failReason=null;
		this.otherParams=null;
	}

	/**
	 * 默认失败，必须传入failReason
	 * @param failReason
	 * others为空
	 */
	public HandleResult(String failReason) {
		this.isSuccess=false;
		this.failReason=failReason;
		this.otherParams=null;
	}


	public HandleResult(boolean isSuccess, String failReason, Map<String, Object> otherParams) {
		this.isSuccess = isSuccess;
		this.failReason = failReason;
		this.otherParams = otherParams;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public String getFailReason() {
		return failReason;
	}

	public Map<String, Object> getOtherParams() {
		return otherParams;
	}




	
	
}
