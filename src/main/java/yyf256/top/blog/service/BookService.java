package yyf256.top.blog.service;

import java.util.Map;

import yyf256.top.blog.util.PageSearch;

public interface BookService {
	public Map<String,Object> getNearlyBooks(int count);
	
	public Map<String,Object> getBooksByPage(PageSearch search);
	
	public Map<String,Object> getBooksCount();
	
	public Map<String,Object> getBookDetail(int id);
}
