package yyf256.top.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyf256.top.blog.bean.NearlyBook;
import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.dao.BookMapper;
import yyf256.top.blog.service.BookService;

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
	
}
