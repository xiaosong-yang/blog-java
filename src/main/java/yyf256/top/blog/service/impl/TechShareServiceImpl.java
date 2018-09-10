package yyf256.top.blog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyf256.top.blog.bean.ShowTechnical;
import yyf256.top.blog.bean.TechncialType;
import yyf256.top.blog.bean.TechnicalDetail;
import yyf256.top.blog.bean.TechnicalSearch;
import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.dao.TechnicalShareMapper;
import yyf256.top.blog.model.TechnicalShareWithBLOBs;
import yyf256.top.blog.service.TechShareService;
import yyf256.top.blog.util.DateUtil;
import yyf256.top.blog.util.PageRefect;
import yyf256.top.blog.util.PageResult;

@Service
public class TechShareServiceImpl implements TechShareService{
	
	@Autowired
	private TechnicalShareMapper techMapper;

	@Override
	public Map<String, Object> getCountByPage(TechnicalSearch search) {
		Map<String,Object> rs=new HashMap<>();
		Integer count=techMapper.getCountByPage(search);
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, count);
		return rs;
	}

	@Override
	public Map<String, Object> getTechByPage(TechnicalSearch search) {
		Map<String,Object> rs=new HashMap<>();
		techMapper.getTechShareByPage(search);
		PageResult pageResult=PageRefect.search(techMapper, "getTechShareByPage", search);
		@SuppressWarnings("unchecked")
		List<TechnicalShareWithBLOBs> techList=(List<TechnicalShareWithBLOBs>) pageResult.getResult();
		List<ShowTechnical> showTech=new ArrayList<>();
		for(TechnicalShareWithBLOBs tech: techList){
			showTech.add(ShowTechnical.technicalShareWithBLOBsToShowTechnical(tech));
		}
		pageResult.setResult(showTech);
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, pageResult);
		return rs;
	}

	@Override
	public Map<String, Object> getTechTypes() {
		Map<String,Object> rs=new HashMap<>();
		List<TechncialType> types=techMapper.getTechTypes();
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, types);
		return rs;
	}

	@Override
	public Map<String, Object> geetTechDetail(int id) {
		Map<String,Object> rs=new HashMap<>();
		TechnicalShareWithBLOBs techDetail=techMapper.selectByPrimaryKey(id);
		TechnicalDetail detail=new TechnicalDetail();
		if(techDetail!=null){
			detail.setContent(techDetail.getContent());
			detail.setTitle(techDetail.getTitle());
			detail.setTime(DateUtil.DateToStr(techDetail.getTime(),"yyyy-MM-dd HH:mm:ss"));
			rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
			rs.put(ResponseConfig.RSP_CONTENT, detail);
		}else{
			rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_FAIL);
			rs.put(ResponseConfig.FAIL_REASON, "输入id不正确");
		}
		return rs;
	}
	
	
	

}
