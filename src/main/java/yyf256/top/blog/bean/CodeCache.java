package yyf256.top.blog.bean;

import java.util.Date;

public class CodeCache {
	/**
	 * code
	 */
	private String code;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public CodeCache(String code, Date createTime) {
		super();
		this.code = code;
		this.createTime = createTime;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
