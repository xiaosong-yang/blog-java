package yyf256.top.blog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyf256.top.blog.bean.ShowMood;
import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.config.SystemConfig;
import yyf256.top.blog.dao.ConfigMapper;
import yyf256.top.blog.dao.MoodMapper;
import yyf256.top.blog.dao.UserInfoMapper;
import yyf256.top.blog.model.Config;
import yyf256.top.blog.model.Mood;
import yyf256.top.blog.model.UserInfo;
import yyf256.top.blog.service.UserService;
import yyf256.top.blog.util.DateUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserInfoMapper userMapper;
	@Autowired
	private MoodMapper moodeMapper;
	@Autowired
	private ConfigMapper configMapper;

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


	@Override
	public Map<String, Object> getUserLogo() {
		Map<String,Object> rs=new HashMap<>();
		UserInfo user = SystemConfig.getUserInfo();
		if(user!=null){
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
			rs.put(ResponseConfig.RSP_CONTENT, user.getLogoUrl());
		}else{
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "未能获取到个人信息");
		}
		return rs;
	}


	@Override
	public Map<String, Object> getPhotoAndTips() {
		Map<String,Object> rs=new HashMap<>();
		UserInfo user = SystemConfig.getUserInfo();
		if(user!=null){
			Map<String,Object> photoAndTips=new HashMap<>();
			photoAndTips.put("photo", user.getPhotoUrl());
			photoAndTips.put("tips", user.getTips());
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
			rs.put(ResponseConfig.RSP_CONTENT, photoAndTips);
		}else{
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "未能获取到个人信息");
		}
		return rs;
	}


	@Override
	public Map<String, Object> getConnectInfo() {
		Map<String,Object> rs=new HashMap<>();
		UserInfo user = SystemConfig.getUserInfo();
		if(user!=null){
			Map<String,Object> content=new HashMap<>();
			content.put("email", user.getEmail());
			content.put("wechat", user.getWechatUrl());
			content.put("qq", user.getQqUrl());
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
			rs.put(ResponseConfig.RSP_CONTENT, content);
		}else{
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "未能获取到个人信息");
		}
		return rs;
	}


	@Override
	public Map<String, Object> getNearlyMoods(int count) {
		Map<String,Object> rs=new HashMap<>();
		List<Mood> list = moodeMapper.getNewestMoods(count);
		if(list!=null){
			List<ShowMood> showMoods=new ArrayList<>();
			for(Mood mood:list){
				showMoods.add(new ShowMood(DateUtil.DateToStr(mood.getTime(), "yyyy年MM月dd日 HH:mm:ss"),
						mood.getMoodText()));
			}
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
			rs.put(ResponseConfig.RSP_CONTENT, showMoods);
		}else{
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "获取心情列表异常");
		}
		return rs;
	}


	@Override
	public Map<String, String> getSystemConfigs() {
		Map<String,String> rs=new HashMap<>();
		List<Config> cfgs=configMapper.getConfigs();
		for(Config cfg:cfgs){
			rs.put(cfg.getKey(), cfg.getValue());
		}
		return rs;
	}


	@Override
	public Map<String,Object> getConfigValue(String key) {
		Map<String,Object> rs=new HashMap<>();
		Map<String,String> cfgs=SystemConfig.getSystemConfigs();
		if(cfgs!=null){
			String value=cfgs.get(key);
			if(null!=value && !"".equals(value)){
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_SUCCESS);
				rs.put(ResponseConfig.RSP_CONTENT, value);
			}else{
				rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
				rs.put(ResponseConfig.FAIL_REASON, "不存在该系统配置");
			}
		}else{
			rs.put(ResponseConfig.RSP_TYPE, ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "获取系统配置异常");
		}
		return rs;
	}


	@Override
	public Map<String, Object> sendRegisterCode(String emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

}
