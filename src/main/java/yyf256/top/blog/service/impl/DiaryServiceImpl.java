package yyf256.top.blog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yyf256.top.blog.bean.DiaryTimeLine;
import yyf256.top.blog.bean.ShowDiary;
import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.dao.DiaryMapper;
import yyf256.top.blog.model.DiaryWithBLOBs;
import yyf256.top.blog.service.DiaryService;
import yyf256.top.blog.util.PageRefect;
import yyf256.top.blog.util.PageResult;
import yyf256.top.blog.util.PageSearch;

@Service
public class DiaryServiceImpl implements DiaryService{
	
	@Autowired
	private DiaryMapper diaryMapper;

	@Override
	public Map<String, Object> getDiaryList(PageSearch search) {
		Map<String,Object> rs=new HashMap<>();
		PageResult reuslt=PageRefect.search(diaryMapper, "getDiaryByPage", search);
		@SuppressWarnings("unchecked")
		List<DiaryWithBLOBs> diarys=(List<DiaryWithBLOBs>) reuslt.getResult();
		List<ShowDiary> showDiarys=new ArrayList<>();
		for(DiaryWithBLOBs diary:diarys){
			showDiarys.add(ShowDiary.diaryWithBLOBsToShowDiary(diary));
		}
		reuslt.setResult(showDiarys);
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, reuslt);
		return rs;
	}

	@Override
	public Map<String, Object> getDiaryCount() {
		Map<String,Object> rs=new HashMap<>();
		Integer count=diaryMapper.getDiaryCount();
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, count);
		return rs;
	}

	@Override
	public Map<String, Object> getNearlyDiarys(int count) {
		Map<String,Object> rs=new HashMap<>();
		List<DiaryWithBLOBs> diarys=diaryMapper.getNearlyDiarys(count);
		List<DiaryTimeLine> timeLine=new ArrayList<>();
		for(DiaryWithBLOBs diary:diarys){
			timeLine.add(DiaryTimeLine.diaryWithBLOBsToDiaryTimeLine(diary));
		}
		rs.put(ResponseConfig.RSP_TYPE,ResponseConfig.RSP_SUCCESS);
		rs.put(ResponseConfig.RSP_CONTENT, timeLine);
		return rs;
	}

}
