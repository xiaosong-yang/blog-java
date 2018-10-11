package yyf256.top.blog.exception;

public enum ExceptionType {

	 CONFIG_ID_NULL("001","系统配置参数为空");
	
	/**
	 * 异常编号
	 */
	private String number;
	/**
	 * 异常名称
	 */
	private String name;
	private ExceptionType(String number, String name) {
		this.number = number;
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
