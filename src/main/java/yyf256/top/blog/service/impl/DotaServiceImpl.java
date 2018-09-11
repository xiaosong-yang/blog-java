package yyf256.top.blog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyf256.top.blog.bean.DotaDetail;
import yyf256.top.blog.bean.ShowDota;
import yyf256.top.blog.bean.ShowDotaTimeLine;
import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.dao.DotaMapper;
import yyf256.top.blog.dao.DotaTimeLineMapper;
import yyf256.top.blog.model.DotaTimeLine;
import yyf256.top.blog.model.DotaWithBLOBs;
import yyf256.top.blog.service.DotaService;
import yyf256.top.blog.util.DateUtil;
import yyf256.top.blog.util.PageRefect;
import yyf256.top.blog.util.PageResult;
import yyf256.top.blog.util.PageSearch;

@Service
public class DotaServiceImpl implements DotaService{
	
	@Autowired
	private DotaTimeLineMapper dotaTimeLineMapper;
	
	@Autowired
	private DotaMapper dotaMapper;

	@Override
	public Map<String, Object> getDotaTimeLine(int count) {
		Map<String,Object> rs=new HashMap<>();
		List<DotaTimeLine> timeLines=dotaTimeLineMapper.getDataTimeLine(count);
		List<ShowDotaTimeLine> showDota=new ArrayList<>();
		for(DotaTimeLine timeLine:timeLines){
			showDota.add(ShowDotaTimeLine.dotaTimeLineToShowDotaTimeLine(timeLine));
		}
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, showDota);
		return rs;
	}

	@Override
	public Map<String, Object> getDotaDiaryCountByPage() {
		Map<String,Object> rs=new HashMap<>();
		Integer count=dotaMapper.getDotaDiaryCount();
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, count);
		return rs;
	}

	@Override
	public Map<String, Object> getDotaDiaryByPage(PageSearch search) {
		Map<String,Object> rs=new HashMap<>();
		PageResult pageResult=PageRefect.search(dotaMapper,"getDotaDiarys", search);
		 @SuppressWarnings("unchecked")
		List<DotaWithBLOBs> dotas=(List<DotaWithBLOBs>) pageResult.getResult();
		List<ShowDota> showDotas=new ArrayList<>();
		for(DotaWithBLOBs dota:dotas){
			showDotas.add(ShowDota.dotaWithBLOBsToShowDota(dota));
		}
		pageResult.setResult(showDotas);
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, pageResult);
		return rs;
	}

	@Override
	public Map<String, Object> getDotaDetail(int id) {
		Map<String,Object> rs=new HashMap<>();
		DotaWithBLOBs dota=dotaMapper.selectByPrimaryKey(id);
		DotaDetail detail=new DotaDetail();
		detail.setContent(dota.getContent());
		detail.setTitle(dota.getTitle());
		detail.setTime(DateUtil.DateToStr(dota.getTime(),"yyyy-MM-dd HH:mm:ss"));
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, detail);
		return rs;
	}

}
