package yyf256.top.blog.bean;

import yyf256.top.blog.model.TechnicalShareWithBLOBs;
import yyf256.top.blog.util.DateUtil;

public class ShowTechnical {
	private Integer id;
	private String title;
	private String overView;
	private String content;
	private String type;
	private String faceUrl;
	private Integer praiseCount;
	private Integer commentCount;
	private Integer browseCount;
	private String time;
	
	public static ShowTechnical technicalShareWithBLOBsToShowTechnical(TechnicalShareWithBLOBs tech){
		ShowTechnical showTech=new ShowTechnical();
		showTech.setId(tech.getId());
		showTech.setTitle(tech.getTitle());
		showTech.setOverView(tech.getOverview());
		showTech.setContent(tech.getContent());
		showTech.setType(tech.getType());
		showTech.setFaceUrl(tech.getFaceUrl());
		showTech.setPraiseCount(tech.getPraiseCount());
		showTech.setCommentCount(tech.getCommentCount());
		showTech.setBrowseCount(tech.getBrowseCount());
		showTech.setTime(DateUtil.DateToStr(tech.getTime(), "yyyy年MM月dd日"));
		return showTech;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverView() {
		return overView;
	}
	public void setOverView(String overView) {
		this.overView = overView;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFaceUrl() {
		return faceUrl;
	}
	public void setFaceUrl(String faceUrl) {
		this.faceUrl = faceUrl;
	}
	public Integer getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getBrowseCount() {
		return browseCount;
	}
	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
