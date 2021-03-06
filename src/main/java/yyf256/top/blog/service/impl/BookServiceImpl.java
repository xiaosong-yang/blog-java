package yyf256.top.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyf256.top.blog.bean.BookDetail;
import yyf256.top.blog.bean.NearlyBook;
import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.dao.BookMapper;
import yyf256.top.blog.model.Book;
import yyf256.top.blog.model.BookWithBLOBs;
import yyf256.top.blog.service.BookService;
import yyf256.top.blog.util.DateUtil;
import yyf256.top.blog.util.PageRefect;
import yyf256.top.blog.util.PageResult;
import yyf256.top.blog.util.PageSearch;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookMapper bookMapper;
	

	@Override
	public Map<String, Object> getNearlyBooks(int count) {
		Map<String,Object> rs=new HashMap<>();
		List<NearlyBook> books=bookMapper.getNearlyBooks(count);
		if(books!=null){
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
			rs.put(ResponseConfig.RSP_CONTENT, books);
		}else{
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "获取最新书籍失败");
		}
		return rs;
	}


	@Override
	public Map<String, Object> getBooksByPage(PageSearch search) {
		Map<String,Object> rs=new HashMap<>();
		PageResult pageResult=PageRefect.search(bookMapper, "getBooksByPage", search);
		rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, pageResult);
		return rs;
	}


	@Override
	public Map<String, Object> getBooksCount() {
		Map<String,Object> rs=new HashMap<>();
		Integer count=bookMapper.getBooksCount();
		rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, count);
		return rs;
	}


	@Override
	public Map<String, Object> getBookDetail(int id) {
		Map<String,Object> rs=new HashMap<>();
		BookWithBLOBs book=bookMapper.selectByPrimaryKey(id);
		BookDetail detail=new BookDetail();
		detail.setContent(book.getInstruction());
		detail.setDownloadUrl(book.getDownloadUrl());
		detail.setTitle(book.getBookName());
		detail.setAuthor(book.getAuthor());
		detail.setTime(DateUtil.DateToStr(book.getUploadTime(), "yyyy-MM-dd HH:mm:ss"));
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, detail);
		return rs;
	}
	
}
