package yyf256.top.blog.service;

import java.util.Map;


import yyf256.top.blog.bean.TechnicalSearch;

public interface TechShareService {
	
	public Map<String,Object> getCountByPage(TechnicalSearch search);
	
	public Map<String,Object> getTechByPage(TechnicalSearch search);
	
	public Map<String,Object> getTechTypes();
	
	public Map<String,Object> geetTechDetail(int id);
}
