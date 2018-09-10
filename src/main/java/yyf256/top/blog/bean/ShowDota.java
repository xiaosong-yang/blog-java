package yyf256.top.blog.bean;

import yyf256.top.blog.model.DotaWithBLOBs;
import yyf256.top.blog.util.DateUtil;

public class ShowDota {
	private Integer id;
	private String title;
	private String overView;
	private String content;
	private String faceUrl;
	private Integer commentCount;
	private Integer praiseCount;
	private Integer browseCount;
	private String type;
	private String time;
	
	public static ShowDota dotaWithBLOBsToShowDota(DotaWithBLOBs dota){
		ShowDota showDota=new ShowDota();
		showDota.setId(dota.getId());
		showDota.setTitle(dota.getTitle());
		showDota.setOverView(dota.getOverview());
		showDota.setContent(dota.getContent());
		showDota.setFaceUrl(dota.getFaceUrl());
		showDota.setCommentCount(dota.getCommentCount());
		showDota.setPraiseCount(dota.getPraiseCount());
		showDota.setBrowseCount(dota.getBrowseCount());
		showDota.setType(dota.getType());
		showDota.setTime(DateUtil.DateToStr(dota.getTime(), "yyyy年MM月dd日"));
		return showDota;
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
	public String getFaceUrl() {
		return faceUrl;
	}
	public void setFaceUrl(String faceUrl) {
		this.faceUrl = faceUrl;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}
	public Integer getBrowseCount() {
		return browseCount;
	}
	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
