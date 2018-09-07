package yyf256.top.blog.util;

public class PageEntity {
	private Integer cur=1;
	private Integer size=10;
	private Integer begin;
	/**
	 * 当前是否为查询总数，这是应用于只传一个查询函数的情况，就是不另外写查询总数的函数
	 */
	private boolean IsOneStr=false;
	
	public PageEntity(Integer cur, Integer size) {
		super();
		this.cur = cur;
		this.size = size;
	}
	
	public PageEntity() {
		super();
	}

	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getCur() {
		return cur;
	}
	public void setCur(Integer cur) {
		this.cur = cur;
	}

	public boolean isIsOneStr() {
		return IsOneStr;
	}

	public void setIsOneStr(boolean isOneStr) {
		IsOneStr = isOneStr;
	}

	
}
