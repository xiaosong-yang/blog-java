package yyf256.top.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnrtec.jupiter.web.security.annotation.JupiterAuth;

import yyf256.top.blog.config.SystemConfig;
import yyf256.top.blog.service.ConsumeService;

@RestController
@RequestMapping("/admin")
public class ConsumeController {
	
	@Autowired
	private ConsumeService consumeService;
	
	@RequestMapping("/insertConsume")
	@JupiterAuth(auth={"Super_Admin"},url=SystemConfig.ROOT_PATH+"/admin/insertConsume")
	public Map<String,Object> insertConsume(String money){
		return consumeService.insertConsume(money); 
	}
	
	@RequestMapping("/insertStandard")
	@JupiterAuth(auth={"Super_Admin"},url=SystemConfig.ROOT_PATH+"/admin/insertStandard")
	public Map<String,Object> insertStandard(String eatMoney){
		return consumeService.insertStandard(eatMoney);
	}
	
}
