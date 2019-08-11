//package yyf256.top.blog;
//
//import java.util.Map;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import common.fasterxml.jackson.core.JsonProcessingException;
//import common.fasterxml.jackson.databind.ObjectMapper;
//
//import yyf256.top.blog.controller.ConsumeController;
//import yyf256.top.blog.service.ConsumeService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes=BlogApplication.class)
//@WebAppConfiguration
//public class BlogApplicationTests {
//
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ConsumeService consumeService;
//
//	@Autowired
//	private ConsumeController consumeController;
//
//	@Before
//	public void setUp(){
//		mockMvc=MockMvcBuilders.standaloneSetup(consumeController).build();
//	}
//
//	/**
//	 * 测试controller需要before函数
//	 * @throws Exception
//	 */
//	@Test
//	public void getConsumeAnalysis() throws Exception {
//		MvcResult msg=mockMvc.perform(MockMvcRequestBuilders.get("/consume/getLogAnalysis")
//				.accept(MediaType.APPLICATION_JSON)).andReturn();
//		System.out.println(msg.getResponse().getContentAsString());
//	}
//
//	/**
//	 * 测试其他函数，直接可以通过spring进行注入bean进行调用测试
//	 */
//	@Test
//	public void test(){
//		Map<String,Object> rs=consumeService.getLogAnalysis();
//		ObjectMapper mapper=new ObjectMapper();
//		String json;
//		try {
//			json = mapper.writeValueAsString(rs);
//			System.out.println(json);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
