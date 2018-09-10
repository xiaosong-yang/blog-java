package yyf256.top.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yyf256.top.blog.service.BookService;
import yyf256.top.blog.util.PageSearch;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/getNearlyBooks")
	public @ResponseBody Map<String,Object> getNearlyBooks(){
		return bookService.getNearlyBooks(5);
	}
	
	@RequestMapping("/geetBooksCount")
	public @ResponseBody Map<String,Object> getBooksCount(){
		return bookService.getBooksCount();
	}
	
	@RequestMapping("/getBooksByPage")
	public @ResponseBody Map<String,Object> getBooksByPage(PageSearch search){
		return bookService.getBooksByPage(search);
	}
}
