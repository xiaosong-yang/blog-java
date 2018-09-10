package yyf256.top.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yyf256.top.blog.service.DiaryService;
import yyf256.top.blog.util.PageSearch;

@Controller
@RequestMapping("/diary")
public class DiaryController {
	
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping("/getDiaryList")
	public @ResponseBody Map<String,Object> getDiaryList(PageSearch search){
		return diaryService.getDiaryList(search); 
	}
	
	@RequestMapping("/getDiaryCount")
	public @ResponseBody Map<String,Object> getDiaryCount(){
		return diaryService.getDiaryCount();
	}
	
	@RequestMapping("/getNearlyDiarys")
	public @ResponseBody Map<String,Object> getNearlyDiarys(){
		return diaryService.getNearlyDiarys(3);
	}
	
	@RequestMapping("/getDiarysDetail")
	public @ResponseBody Map<String,Object> getDiarysDetail(int id){
		return diaryService.getDiarysDetail(id);
	}
	
}
