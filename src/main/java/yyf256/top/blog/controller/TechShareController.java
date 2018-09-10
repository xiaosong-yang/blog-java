package yyf256.top.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yyf256.top.blog.bean.TechnicalSearch;
import yyf256.top.blog.service.TechShareService;

@Controller
@RequestMapping("/technical")
public class TechShareController {
	
	@Autowired
	private TechShareService techService;
	
	@RequestMapping("/getCountByPage")
	public @ResponseBody Map<String,Object> getCountByPage(TechnicalSearch search){
		return techService.getCountByPage(search);
	}
	
	@RequestMapping("/getTechByPage")
	public @ResponseBody Map<String,Object> getTechByPage(TechnicalSearch search){
		return techService.getTechByPage(search);
	}
	
	@RequestMapping("/getTechTypes")
	public @ResponseBody Map<String,Object> getTechTypes(){
		return techService.getTechTypes();
	}
	
	@RequestMapping("/getTechnicalDetail")
	public @ResponseBody Map<String,Object> getTechnicalDetail(int id){
		return techService.geetTechDetail(id);
	}
}
