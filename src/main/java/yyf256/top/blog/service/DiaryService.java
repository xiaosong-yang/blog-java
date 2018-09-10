package yyf256.top.blog.service;

import java.util.Map;

import yyf256.top.blog.util.PageSearch;

public interface DiaryService {
	
	public Map<String,Object> getDiaryList(PageSearch search);
	
	public Map<String,Object> getDiaryCount();
	
	public Map<String,Object> getNearlyDiarys(int count);
}
