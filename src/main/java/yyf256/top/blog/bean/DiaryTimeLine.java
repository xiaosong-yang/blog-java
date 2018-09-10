package yyf256.top.blog.bean;

import yyf256.top.blog.model.DiaryWithBLOBs;
import yyf256.top.blog.util.DateUtil;

public class DiaryTimeLine {
	private String title;
	private String overView;
	
	public static DiaryTimeLine diaryWithBLOBsToDiaryTimeLine(DiaryWithBLOBs diary){
		DiaryTimeLine timeLine=new DiaryTimeLine();
		String date=DateUtil.DateToStr(diary.getTime(), "yyyy年MM月dd日");
		timeLine.setTitle(date+"  "+diary.getTitle());
		timeLine.setOverView(diary.getOverview());
		return timeLine;
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
	
	
}
