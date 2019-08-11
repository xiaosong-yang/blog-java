//package yyf256.top.blog.controller;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import common.pnrtec.jupiter.web.security.annotation.JupiterAuth;
//
//import yyf256.top.blog.config.SystemConfig;
//import yyf256.top.blog.consume.config.ConsumeCoreConfig;
//import yyf256.top.blog.service.ConsumeService;
//
//@RestController
//@RequestMapping("/consume")
//public class ConsumeController {
//
//	@Autowired
//	private ConsumeService consumeService;
//
//	@RequestMapping("/insertConsume")
//	@JupiterAuth(auth={"Super_Admin"},url=SystemConfig.ROOT_PATH+"/admin/insertConsume")
//	public Map<String,Object> insertConsume(String money){
//		return consumeService.insertConsume(money,ConsumeCoreConfig.DEFAULT_TOKEN);
//	}
//
//	@RequestMapping("/insertConsumeWithToken")
//	public Map<String,Object> insertConsumeWithToken(String money,String token){
//		return consumeService.insertConsume(money,token);
//	}
//
//	@RequestMapping("/insertStandard")
//	@JupiterAuth(auth={"Super_Admin"},url=SystemConfig.ROOT_PATH+"/admin/insertStandard")
//	public Map<String,Object> insertStandard(String eatMoney){
//		return consumeService.insertStandard(eatMoney);
//	}
//
//	@RequestMapping("/getLogAnalysis")
//	@JupiterAuth(auth={"Super_Admin"},url=SystemConfig.ROOT_PATH+"/admin/getLogAnalysis")
//	public Map<String,Object> getLogAnalysis(){
//		return consumeService.getLogAnalysis();
//	}
//
//}
