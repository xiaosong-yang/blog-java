package yyf256.top.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yyf256.top.blog.service.DotaService;
import yyf256.top.blog.util.PageSearch;

@Controller
@RequestMapping("/dota")
public class DotaController {
	
	@Autowired
	private DotaService dotaService;
	
	@RequestMapping("/getDataTimeLine")
	public @ResponseBody Map<String,Object> getDataTimeLine(){
		return dotaService.getDataTimeLine(5);
	}
	
	@RequestMapping("/getDotaDiaryCountByPage")
	public @ResponseBody Map<String,Object> getDotaDiaryCountByPage(){
		return dotaService.getDotaDiaryCountByPage();
	}
	
	@RequestMapping("/getDotaByPage")
	public @ResponseBody Map<String,Object> getDotaByPage(PageSearch search){
		return dotaService.getDotaDiaryByPage(search);
	}
}