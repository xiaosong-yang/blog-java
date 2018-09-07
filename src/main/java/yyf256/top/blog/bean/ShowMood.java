package yyf256.top.blog.bean;

public class ShowMood {
	private String time;
	private String content;
	
	public ShowMood(String time, String content) {
		super();
		this.time = time;
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
