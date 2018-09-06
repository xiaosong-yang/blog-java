package yyf256.top.blog.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.config.SystemConfig;
import yyf256.top.blog.dao.UserInfoMapper;
import yyf256.top.blog.model.UserInfo;
import yyf256.top.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserInfoMapper userMapper;
	

	@Override
	public Map<String, Object> getUserInfo() {
		Map<String,Object> rs=new HashMap<>();
		UserInfo user = SystemConfig.getUserInfo();
		if(user!=null){
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
			rs.put(ResponseConfig.RSP_CONTENT, user);
		}else{
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "未能获取到个人信息");
		}
		return rs;
	}
	
	
	@Override
	public UserInfo getUserInfoDirect() {
		return userMapper.getNewestInfo();
	}

}
