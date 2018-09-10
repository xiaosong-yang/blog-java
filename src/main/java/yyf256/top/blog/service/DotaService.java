package yyf256.top.blog.service;

import java.util.Map;

import yyf256.top.blog.util.PageSearch;

public interface DotaService {
	
	public Map<String,Object> getDataTimeLine(int count);
	
	public Map<String,Object> getDotaDiaryCountByPage();
	
	public Map<String,Object> getDotaDiaryByPage(PageSearch search);
	
	public Map<String,Object> getDotaDetail(int id);
}
