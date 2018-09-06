package yyf256.top.blog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import yyf256.top.blog.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public Map<String, Object> test() {
		Map<String,Object> rs=new HashMap<String, Object>();
		return rs;
	}

}
