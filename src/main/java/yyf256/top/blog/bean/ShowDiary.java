package yyf256.top.blog.bean;

import yyf256.top.blog.model.DiaryWithBLOBs;
import yyf256.top.blog.util.DateUtil;

public class ShowDiary {
	private String faceUrl;
	
	private String overView;
	
	private String content;
	
	private Integer praiseCount;
	
	private Integer browseCount;
	
	private Integer commentCount;
	
	private String time;
	
	private String type;
	
	private String title;
	
	private Integer id;
	
	public static ShowDiary diaryWithBLOBsToShowDiary(DiaryWithBLOBs diary){
		ShowDiary showdiary=new ShowDiary();
		showdiary.browseCount=diary.getBrowseCount();
		showdiary.commentCount=diary.getCommentCount();
		showdiary.praiseCount=diary.getPraiseCount();
		showdiary.content=diary.getContent();
		showdiary.faceUrl=diary.getFaceUrl();
		showdiary.id=diary.getId();
		showdiary.overView=diary.getOverview();
		showdiary.title=diary.getTitle();
		showdiary.type=diary.getType();
		showdiary.time=DateUtil.DateToStr(diary.getTime(), "yyyy年MM月dd日");
		return showdiary;
	}
	

	public String getFaceUrl() {
		return faceUrl;
	}

	public void setFaceUrl(String faceUrl) {
		this.faceUrl = faceUrl;
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

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
