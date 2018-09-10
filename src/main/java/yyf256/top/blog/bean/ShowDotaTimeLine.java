package yyf256.top.blog.bean;

import yyf256.top.blog.model.DotaTimeLine;
import yyf256.top.blog.util.DateUtil;

public class ShowDotaTimeLine {
	private String title;
	private String url;
	private String time;
	
	public static ShowDotaTimeLine dotaTimeLineToShowDotaTimeLine(DotaTimeLine dota){
		ShowDotaTimeLine timeLine=new ShowDotaTimeLine();
		timeLine.setTime(DateUtil.DateToStr(dota.getTime(), "yyyy年MM月"));
		timeLine.setTitle(dota.getTitle());
		timeLine.setUrl(dota.getContentUrl());
		return timeLine;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}	
